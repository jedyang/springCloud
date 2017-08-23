package com.yunsheng.servicveconsumer.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-hi")
public interface FeignConsumeService {

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromFeign(@RequestParam(value = "name") String name);
}
