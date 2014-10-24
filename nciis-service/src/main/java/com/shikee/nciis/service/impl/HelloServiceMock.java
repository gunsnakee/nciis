package com.shikee.nciis.service.impl;

import com.shikee.nciis.service.api.HelloService;

/**
 * Created by Administrator on 2014/10/23.
 */
public class HelloServiceMock implements HelloService {
    @Override
    public String sayHello(String user) throws Exception {
        return "mock run...";
    }
}
