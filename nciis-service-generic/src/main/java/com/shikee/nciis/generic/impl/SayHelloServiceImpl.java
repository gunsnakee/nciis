package com.shikee.nciis.generic.impl;

import com.alibaba.dubbo.rpc.RpcContext;
import com.shikee.nciis.generic.api.SayHelloService;
import com.shikee.nciis.pojo.Person;

/**
 * Created by Administrator on 2014/10/20.
 */
public class SayHelloServiceImpl implements SayHelloService {
    @Override
    public String sayHello(String user) {
        System.out.println("hide attachment: "+RpcContext.getContext().getAttachment("hide parameter"));
        return "hello "+user;
    }

    @Override
    public Person helloPerson(Person person) {
        System.out.println("hello: "+person);
        return person;
    }
}
