package lzy.module.customer.controller;

import lzy.common.CommonDefine;
import lzy.module.customer.domain.CustomerDomain;
import lzy.module.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * User: longzhiyou
 * Date: 2017/4/7
 * Time: 8:33
 */
@RestController
@RequestMapping(value = CommonDefine.BASE_URI+"/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(method= RequestMethod.GET)
    public List<CustomerDomain> index() {

        return customerService.getCustomers();

    }

    @RequestMapping(method= RequestMethod.POST,consumes = "application/json")
    public CustomerDomain create(@RequestBody CustomerDomain customerDomain) {

        CustomerDomain customerDomain1 = new CustomerDomain();

        return customerDomain1;

    }


}
