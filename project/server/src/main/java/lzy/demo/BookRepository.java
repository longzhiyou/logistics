package lzy.demo;

/**
 *
 * Created by bukeyan on 2017/5/13.
 */
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer>{
}