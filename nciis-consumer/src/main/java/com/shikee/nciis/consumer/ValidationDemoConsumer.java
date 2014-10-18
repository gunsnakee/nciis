package com.shikee.nciis.consumer;

import com.shikee.nciis.service.api.NciisInterf;
import com.shikee.nciis.service.api.ValidationDemo;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 14-10-15.
 */
public class ValidationDemoConsumer {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"validation-demo-consumer.xml"});
        context.start();

        ValidationDemo validationDemoService = (ValidationDemo)context.getBean("validationDemoService"); // 获取远程服务代理
        validationDemoService.delete(-1,"abc456");




    }
}
