package com.shikee.nciis.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by Administrator on 14-10-18.
 */
public class ValidationDemoProvider {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"validation-demo-provider.xml"});
        context.start();
        System.in.read();
    }
}
