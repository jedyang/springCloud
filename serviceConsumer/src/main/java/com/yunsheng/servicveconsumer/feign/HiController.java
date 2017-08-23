package com.yunsheng.servicveconsumer.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {
    @Autowired
    FeignConsumeService feignConsumeService;

    @RequestMapping(value = "/feignHi", method = RequestMethod.GET)
    public String sayHi(@RequestParam(value = "name") String name){
        return feignConsumeService.sayHiFromFeign(name);
    }


}
