package lzy.module.party.person.service;

import lzy.module.party.entity.Party;
import lzy.module.party.entity.PartyRole;
import lzy.module.party.entity.RoleType;
import lzy.module.party.person.entity.Person;
import lzy.module.party.person.repository.PersonRepository;
import lzy.utils.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * User: longzhiyou
 * Date: 2017/4/10
 * Time: 14:35
 */
@Service
public class PersonService {
//
//    @Autowired
//    PartyRepository partyRepository;

    @Autowired
    PersonRepository personRepository;


    @Transactional
    public Person create(Person person){

        /**
         *  增加一个person的逻辑
         *  - 创建一个 party
         *  - 创建一个 person
         * [2017-04-10 add by longzhiyou]
         */


        RoleType roleTypeA = new RoleType();
        roleTypeA.setRoleTypeId(1);

        PartyRole partyRole = new PartyRole();
        partyRole.setParty(person);
        partyRole.setRoleType(roleTypeA);
        partyRole.setPartyRoleId(10);

        person.getPartyRoles().add(partyRole);

        return personRepository.save(person);


    }

}
