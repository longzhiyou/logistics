package lzy.module.party.controller;

import lzy.common.CommonDefine;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: longzhiyou
 * Date: 2017/4/7
 * Time: 8:33
 */
@RestController
@RequestMapping(value = CommonDefine.BASE_URI+"/persons")
public class PersonController {


    @RequestMapping(method= RequestMethod.GET)
    public String index() {

        return "persons#index";

    }


}
