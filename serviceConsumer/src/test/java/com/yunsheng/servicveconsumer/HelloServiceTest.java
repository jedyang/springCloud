package com.yunsheng.servicveconsumer;

import com.netflix.discovery.shared.Application;
import com.yunsheng.servicveconsumer.ribbon.HelloService;
import com.yunsheng.servicveconsumer.ribbon.ServicveConsumerApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=ServicveConsumerApplication.class)
public class HelloServiceTest {

    @Autowired
    HelloService helloService;

    @Test
    public void sayHello() throws Exception {
        for (int i = 0; i < 10; i++){
            System.out.println(helloService.sayHello("yunsheng"));
        }

    }

}