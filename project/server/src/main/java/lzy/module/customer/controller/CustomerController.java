package lzy.module.customer.controller;

import lzy.common.CommonDefine;
import lzy.module.customer.domain.CustomerDomain;
import lzy.module.customer.service.CustomerService;
import lzy.module.file.storage.StorageService;
import lzy.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    StorageService storageService;

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

//    @RequestBody MultipartFile uploadFiles
    @RequestMapping(method= RequestMethod.POST,consumes = "multipart/form-data")
    public CustomerDomain createForMultipart(
            @RequestParam("jsonStr") String jsonStr,
//            @RequestParam(value="avatar") MultipartFile avatar
            @RequestParam(value="avatar",required =false ) MultipartFile avatar
//            ,@RequestParam("files") MultipartFile[] uploadFiles
    ) {

        CustomerDomain customerDomain = JsonUtil.json2JavaBean(jsonStr, CustomerDomain.class);

        if (avatar!=null) {
            storageService.store(avatar);
        }

        return customerDomain;

    }


}
