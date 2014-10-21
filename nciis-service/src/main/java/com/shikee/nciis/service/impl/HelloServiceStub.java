package com.shikee.nciis.service.impl;

import com.shikee.nciis.service.api.HelloService;

/**
 * Created by Administrator on 2014/10/21.
 */
public class HelloServiceStub implements HelloService {
    private final HelloService helloService;

    public HelloServiceStub(HelloService helloService) {
        this.helloService = helloService;
    }

    @Override
    public String sayHello(String user) throws Exception {
        System.out.println("在consumer做点事情，例如写Threadloacal本地缓存，提前验证参数");
        return helloService.sayHello(user);
    }
}
