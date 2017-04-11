package lzy.module.party.domain;

import lzy.module.party.entity.Party;
import lzy.module.party.entity.PartyRoleType;
import lzy.module.party.entity.Person;
import lzy.module.party.repository.PartyRepository;
import lzy.module.party.repository.PartyRoleTypeRepository;
import lzy.module.party.repository.PersonRepository;
import lzy.module.party.repository.RoleTypeRepository;
import lzy.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 当事人角色类型服务
 * User: longzhiyou
 * Date: 2017/4/10
 * Time: 14:35
 */
@Service
public class PartyRoleTypeService {

    @Autowired
    RoleTypeRepository roleTypeRepository;

    @Autowired
    PartyRoleTypeRepository partyRoleTypeRepository;


    @Transactional
    public PartyRoleType create(PartyRoleType partyRoleType){

        /**
         *  由于role_type已经由系统初始化了,此处主要是进行表关联
         * [2017-04-11 add by longzhiyou]
         */

//        if (partyRoleType==null || partyRoleType.getRoleTypeId()==null) {
//
//        }
        //查找是否存在此角色类型
//        PartyRoleType one = partyRoleTypeRepository.findOne(1);

        return partyRoleTypeRepository.save(partyRoleType);

    }

}
