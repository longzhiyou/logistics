package lzy.demo;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by bukeyan on 2017/5/12.
 */
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
}