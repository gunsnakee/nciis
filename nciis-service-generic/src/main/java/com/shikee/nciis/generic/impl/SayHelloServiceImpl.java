package com.shikee.nciis.generic.impl;

import com.shikee.nciis.generic.api.SayHelloService;

/**
 * Created by Administrator on 2014/10/20.
 */
public class SayHelloServiceImpl implements SayHelloService {
    @Override
    public String sayHello(String user) {
        return "hello "+user;
    }
}
