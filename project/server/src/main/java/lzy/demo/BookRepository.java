package lzy.demo;

/**
 *
 * Created by bukeyan on 2017/5/13.
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface BookRepository extends JpaRepository<Book, Integer>
        ,QueryDslPredicateExecutor {
}