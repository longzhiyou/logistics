package lzy.module.party.person.service;

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

//        PartyBak party = new PartyBak();
//        party.setPartyId(IdUtils.getId());
//        PartyBak party1 = partyRepository.save(party);
        person.setPartyId(IdUtils.getId());
        return personRepository.save(person);


    }

}
