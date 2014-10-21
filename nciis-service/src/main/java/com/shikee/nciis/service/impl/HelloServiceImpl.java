package com.shikee.nciis.service.impl;

import com.shikee.nciis.service.api.HelloService;

/**
 * Created by Administrator on 2014/10/21.
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String user) throws Exception {
        throw  new Exception("this is a test exception");
        //return "hello "+user;
    }
}
