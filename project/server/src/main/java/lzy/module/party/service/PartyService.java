package lzy.module.party.service;

import lzy.module.party.entity.*;
import lzy.utils.IdUtils;
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
public class PartyService {


    @Autowired
    private PartyRepository partyRepository;

    @Autowired
    RoleTypeRepository roleTypeRepository;

    @Transactional
    public void create(){

        // create new
        Party partyA = new Party();
        partyA.setPartyId(IdUtils.getId());


        RoleType roleTypeA = new RoleType();
        roleTypeA.setDescription("RoleType A");
        roleTypeA.setRoleTypeId(1);

        PartyRole partyRole = new PartyRole();
        partyRole.setParty(partyA);
        partyRole.setRoleType(roleTypeA);
        partyRole.setPartyRoleId(10);

        partyA.getPartyRoles().add(partyRole);


//        roleTypeRepository.save(roleTypeA);
        partyRepository.save(partyA);

    }

}
