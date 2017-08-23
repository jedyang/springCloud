package com.yunsheng.servicveconsumer.ribbon;

import com.yunsheng.servicveconsumer.feign.FeignConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {
    @Autowired
    HelloService helloService;

    @RequestMapping(value = "/ribbonHi", method = RequestMethod.GET)
    public String sayHi(@RequestParam(value = "name") String name) {
        return helloService.sayHello(name);
    }


}
