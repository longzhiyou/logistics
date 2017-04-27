package lzy.common.domain;

import lzy.common.CommonDefine;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 * @author Kristijan Georgiev
 *
 * @param <T> the class of the entity
 * @param <ID> the ID class of the entity
 * 
 *            Custom implementation for soft deleting
 */
public class SoftDeletesRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID>
		implements SoftDeletesRepository<T, ID> {

	private final JpaEntityInformation<T, ?> entityInformation;
	private final EntityManager em;
	private final Class<T> domainClass;
	private static final String DELETED_FIELD = CommonDefine.DELETED_FIELD;

	public SoftDeletesRepositoryImpl(Class<T> domainClass, EntityManager em) {
		super(domainClass, em);
		this.em = em;
		this.domainClass = domainClass;
		this.entityInformation = JpaEntityInformationSupport.getEntityInformation(domainClass, em);
	}


	@Override
	@Transactional
	public void softDelete(ID id) {
		Assert.notNull(id, "The given id must not be null!");
		softDelete(id, LocalDateTime.now());
	}

	@Override
	@Transactional
	public void softDelete(T entity) {
		Assert.notNull(entity, "The entity must not be null!");
		softDelete(entity, LocalDateTime.now());
	}

	@Override
	@Transactional
	public void softDelete(Iterable<? extends T> entities) {
		Assert.notNull(entities, "The given Iterable of entities not be null!");
		for (T entity : entities)
			softDelete(entity);
	}

	@Override
	@Transactional
	public void softDeleteAll() {
		for (T entity : findAll())
			softDelete(entity);
	}

	@Override
	@Transactional
	public void scheduleSoftDelete(ID id, LocalDateTime localDateTime) {
		softDelete(id, localDateTime);
	}

	@Override
	@Transactional
	public void scheduleSoftDelete(T entity, LocalDateTime localDateTime) {
		softDelete(entity, localDateTime);
	}

	private void softDelete(ID id, LocalDateTime localDateTime) {
		Assert.notNull(id, "The given id must not be null!");

		T entity = findOne(id);

		if (entity == null)
			throw new EmptyResultDataAccessException(
					String.format("No %s entity with id %s exists!", entityInformation.getJavaType(), id), 1);

		softDelete(entity, localDateTime);
	}

	private void softDelete(T entity, LocalDateTime localDateTime) {
		Assert.notNull(entity, "The entity must not be null!");

		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaUpdate<T> update = cb.createCriteriaUpdate((Class<T>) domainClass);

		Root<T> root = update.from((Class<T>) domainClass);

		update.set(DELETED_FIELD, localDateTime);

		update.where(
				cb.equal(root.<ID>get(entityInformation.getIdAttribute().getName()), entityInformation.getId(entity)));

		em.createQuery(update).executeUpdate();
	}



	private static final class ByIdSpecification<T, ID> implements Specification<T> {

		private final JpaEntityInformation<T, ?> entityInformation;
		private final ID id;

		public ByIdSpecification(JpaEntityInformation<T, ?> entityInformation, ID id) {
			this.entityInformation = entityInformation;
			this.id = id;
		}

		@Override
		public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
			return cb.equal(root.<ID>get(entityInformation.getIdAttribute().getName()), id);
		}
	}

	@SuppressWarnings("rawtypes")
	private static final class ByIdsSpecification<T> implements Specification<T> {

		private final JpaEntityInformation<T, ?> entityInformation;

		ParameterExpression<Iterable> parameter;

		public ByIdsSpecification(JpaEntityInformation<T, ?> entityInformation) {
			this.entityInformation = entityInformation;
		}

		@Override
		public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
			Path<?> path = root.get(entityInformation.getIdAttribute());
			parameter = cb.parameter(Iterable.class);
			return path.in(parameter);
		}
	}

	/*
	 * Specification to check if the DELETED_FIELD is null
	 */
	private static final class DeletedIsNull<T> implements Specification<T> {
		@Override
		public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
			return cb.isNull(root.<LocalDateTime>get(DELETED_FIELD));
		}
	}

	/*
	 * Specification to check if the DELETED_FIELD is greather than the current
	 * LocalDateTime
	 */
	private static final class DeletedTimeGreatherThanNow<T> implements Specification<T> {
		@Override
		public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
			return cb.greaterThan(root.<LocalDateTime>get(DELETED_FIELD), LocalDateTime.now());
		}
	}

	/*
	 * Combined Specification from DeletedIsNull and DeletedTimeGreatherThanNow
	 * to check if the entity is soft deleted or not
	 */
	private static <T> Specification<T> notDeleted() {
		return Specifications.where(new DeletedIsNull<T>()).or(new DeletedTimeGreatherThanNow<T>());
	}
}
