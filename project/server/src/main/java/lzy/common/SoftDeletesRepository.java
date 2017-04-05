package lzy.common;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 * @author Kristijan Georgiev
 *
 * @param <T> the class of the entity
 * @param <ID> the ID class of the entity
 * 
 * NoRepositoryBean interface for the soft delete functionality
 */

@Transactional
@NoRepositoryBean
public interface SoftDeletesRepository<T, ID extends Serializable> extends PagingAndSortingRepository<T, ID> {


	@Modifying
	void delete(ID id);

	@Modifying
	void softDelete(ID id);

	@Modifying
	void softDelete(T entity);

	@Modifying
	void softDelete(Iterable<? extends T> entities);

	@Modifying
	void softDeleteAll();

	@Modifying
	void scheduleSoftDelete(ID id, LocalDateTime localDateTime);

	@Modifying
	void scheduleSoftDelete(T entity, LocalDateTime localDateTime);



}
