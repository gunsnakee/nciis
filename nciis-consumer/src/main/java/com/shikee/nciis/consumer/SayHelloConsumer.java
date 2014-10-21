package com.shikee.nciis.consumer;

import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.service.GenericService;
import com.shikee.nciis.pojo.Person;
import com.shikee.nciis.service.api.NciisInterf;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2014/10/20.
 */
public class SayHelloConsumer {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"say-hello-consumer.xml"});
        context.start();


        //隐式传参

        RpcContext.getContext().setAttachment("hide parameter","fuck");

        GenericService sayHelloService = (GenericService)context.getBean("sayHelloService"); // 获取远程服务代理
        Object hello = sayHelloService.$invoke("sayHello",new String[]{"java.lang.String"},new Object[]{"wujw"});

        System.out.println( hello ); // 显示调用结果




       /* Map<String,Object> person = new HashMap<String,Object>();
        //person.put("class", Person.class.getCanonicalName());
        person.put("name","wujw");
        person.put("sex","男");

        Object helloPeron = sayHelloService.$invoke("helloPerson", new String[]{Person.class.getCanonicalName()}, new Object[]{person});

        System.out.println( helloPeron ); // 显示调用结果*/

        // 上下文信息

        System.out.println("is consumer: " + RpcContext.getContext().isConsumerSide());
        System.out.println("is provider: "+RpcContext.getContext().isProviderSide());
        System.out.println("arguments: " + RpcContext.getContext().getArguments());
        System.out.println("localhost: "+RpcContext.getContext().getLocalHost());
        System.out.println("localhost name: "+RpcContext.getContext().getLocalHostName());
        System.out.println("remote host: "+RpcContext.getContext().getRemoteHost());
        System.out.println("url: "+RpcContext.getContext().getUrl());
        System.out.println("parameter types: "+ Arrays.asList(RpcContext.getContext().getParameterTypes()));
        System.out.println("remote address: "+ RpcContext.getContext().getRemoteAddressString());

    }
}
