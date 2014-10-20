package com.shikee.nciis.consumer;

import com.alibaba.dubbo.rpc.service.GenericService;
import com.shikee.nciis.service.api.NciisInterf;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2014/10/20.
 */
public class SayHelloConsumer {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"say-hello-consumer.xml"});
        context.start();

        GenericService sayHelloService = (GenericService)context.getBean("sayHelloService"); // 获取远程服务代理
        Object hello = sayHelloService.$invoke("sayHello",new String[]{"java.lang.String"},new Object[]{"wujw"});

        System.out.println( hello ); // 显示调用结果



    }
}
