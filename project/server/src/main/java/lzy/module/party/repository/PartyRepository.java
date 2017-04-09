package lzy.module.party.repository;

/**
 * User: longzhiyou
 * Date: 2017/4/7
 * Time: 14:42
 */

import lzy.module.party.domain.Party;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartyRepository extends JpaRepository<Party, Integer>{
}