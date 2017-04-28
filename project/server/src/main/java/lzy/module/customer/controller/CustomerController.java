package lzy.module.customer.controller;

import lombok.AllArgsConstructor;
import lzy.common.CommonDefine;
import lzy.module.customer.domain.CustomerDomain;
import lzy.module.customer.service.CustomerService;
import lzy.module.file.storage.StorageService;
import lzy.utils.JsonUtils;
import org.springframework.data.domain.Pageable;
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

@AllArgsConstructor
public class CustomerController {

//    @Autowired
    final StorageService storageService;

//    @Autowired
    final CustomerService customerService;


    @RequestMapping(method= RequestMethod.GET)
    public List<CustomerDomain> index(Pageable pageable) {

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

        CustomerDomain customerDomain = JsonUtils.json2JavaBean(jsonStr, CustomerDomain.class);

        if (avatar!=null) {
            storageService.store(avatar);
        }

        return customerDomain;

    }


}
