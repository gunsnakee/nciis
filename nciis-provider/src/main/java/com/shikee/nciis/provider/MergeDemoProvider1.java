package com.shikee.nciis.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by Administrator on 2014/10/18.
 */
public class MergeDemoProvider1 {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"merge-demo-provider1.xml"});
        context.start();
        System.in.read();
    }
}
