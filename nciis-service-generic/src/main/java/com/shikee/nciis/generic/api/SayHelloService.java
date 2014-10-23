package com.shikee.nciis.generic.api;

import com.shikee.nciis.pojo.Person;

/**
 * Created by Administrator on 2014/10/20.
 */
public interface SayHelloService {
    String sayHello(String user);
    Person helloPerson(Person person);
}
