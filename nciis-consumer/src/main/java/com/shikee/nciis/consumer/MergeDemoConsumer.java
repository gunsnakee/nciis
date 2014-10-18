package com.shikee.nciis.consumer;

import com.shikee.nciis.service.api.MergeDemo;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Administrator on 2014/10/18.
 */
public class MergeDemoConsumer {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"merge-demo-consumer.xml"});
        context.start();

        MergeDemo mergeService = (MergeDemo) context.getBean("mergeService"); // 获取远程服务代理
        List<String> strings = mergeService.merge();

        System.out.println(strings); // 显示调用结果

        System.out.println("---------------------------"); // 显示调用结果

        MergeDemo mergeService2 = (MergeDemo) context.getBean("mergeService2"); // 获取远程服务代理
        List<String> strings2 = mergeService2.merge();
        System.out.println(strings2); // 显示调用结果


    }
}
