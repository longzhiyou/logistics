package lzy.module.party.repository;

/**
 * User: longzhiyou
 * Date: 2017/4/7
 * Time: 14:42
 */

import lzy.module.party.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long>{

}