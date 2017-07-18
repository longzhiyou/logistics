package lzy.demo;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 *
 * Created by bukeyan on 2017/5/13.
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>
        , QueryDslPredicateExecutor<Student>{

}
