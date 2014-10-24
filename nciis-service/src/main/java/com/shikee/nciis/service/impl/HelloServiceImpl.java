package com.shikee.nciis.service.impl;

import com.alibaba.dubbo.rpc.RpcException;
import com.shikee.nciis.service.api.HelloService;

/**
 * Created by Administrator on 2014/10/21.
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String user) throws RpcException {
        //throw  new Exception("this is a test exception");
        System.out.println("provider execute sayhello..."+user);
        if("5".equals(user)){
            throw new RpcException("if equals 5,throw a new exception");
        }
        return "hello "+user;
    }
}
