package com.shikee.nciis.consumer;

import com.shikee.nciis.service.api.HelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2014/10/20.
 */
public class SayHelloInjvmConsumer {


    static ClassPathXmlApplicationContext getContext(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"say-hello-consumer-injvm.xml"});
        context.start();
        return context;
    }

    static HelloService getHelloService(){
        return  (HelloService) getContext().getBean("sayHelloService");
    }

    public static void main(String[] args) throws Exception {
        System.out.println( getHelloService().sayHello("wujw") );
    }
}
