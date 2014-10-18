package com.shikee.nciis.provider;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by Administrator on 2014/10/15.
 */
public class NciisProvider  {
   public static void main(String[] args) throws IOException {
       ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"provider.xml"});
       context.start();
       System.in.read();
   }
}
