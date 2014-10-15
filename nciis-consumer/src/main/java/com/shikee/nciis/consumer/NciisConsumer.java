package com.shikee.nciis.consumer;

import com.shikee.nciis.service.NciisInterf;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 14-10-15.
 */
public class NciisConsumer {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"consumer.xml"});
        context.start();

        NciisInterf demoService = (NciisInterf)context.getBean("nciisService"); // 获取远程服务代理
        String hello = demoService.getUser("test","123213123");

        System.out.println( hello ); // 显示调用结果
    }
}
