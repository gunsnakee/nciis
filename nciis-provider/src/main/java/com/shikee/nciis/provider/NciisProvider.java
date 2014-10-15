package com.shikee.nciis.provider;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by Administrator on 2014/10/15.
 */
public class NciisProvider  {
   public static void main(String[] args){
       ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"provider.xml"});
       context.start();

       try {
           System.in.read(); // 按任意键退出
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
}
