package com.shikee.nciis.service.impl;

import com.shikee.nciis.service.api.HelloService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2014/10/21.
 */
public class HelloServiceStub implements HelloService {

    private Map<String,String> resCache = new HashMap<String, String>();

    private final HelloService helloService;

    public HelloServiceStub(HelloService helloService) {
        this.helloService = helloService;
    }

    @Override
    public String sayHello(String user) throws Exception {
        //System.out.println("在consumer做点事情，例如写Threadloacal本地缓存，提前验证参数");
        if(resCache.containsKey(user)){
            return  "consumer: "+resCache.get(user);
        }
        String tt =  helloService.sayHello(user);
        resCache.put(user,tt);
        return tt;
    }
}
