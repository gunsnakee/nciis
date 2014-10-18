package com.shikee.nciis.consumer;

import com.shikee.nciis.service.api.NciisInterf;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 14-10-15.
 */
public class NciisConsumer {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"consumer.xml"});
        context.start();

        NciisInterf nciisServiceXfire = (NciisInterf)context.getBean("nciisServiceXfire"); // 获取远程服务代理
        String hello = nciisServiceXfire.getUser("XXXX","4506034646464");

        System.out.println( hello ); // 显示调用结果


        NciisInterf nciisServiceJax = (NciisInterf)context.getBean("nciisServiceJax");
        hello=nciisServiceJax.getUser("YYYY","416714");
        System.out.println( hello ); // 显示调用结果

    }
}
