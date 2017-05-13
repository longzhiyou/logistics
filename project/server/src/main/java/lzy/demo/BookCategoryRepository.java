package lzy.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by bukeyan on 2017/5/13.
 */
@Repository
public interface BookCategoryRepository extends JpaRepository<BookCategory, Integer> {
}
