package com.shikee.nciis.consumer;

import com.shikee.nciis.service.api.CallbackAction;
import com.shikee.nciis.service.api.CallbackService;
import com.shikee.nciis.service.api.HelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Random;

/**
 * Created by Administrator on 2014/10/21.
 */
public class CallbackConsumer {
    static ClassPathXmlApplicationContext getContext(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"callback-consumer.xml"});
        context.start();
        return context;
    }

    static CallbackService getService(){
        return  (CallbackService) getContext().getBean("callbackService");
    }

    public static void main(String[] args) throws Exception {
        getService().addListener("wujw",new CallbackAction() {

            private Random r = new Random(47);

            @Override
            public int callConsumer(String msg) {
                int i = r.nextInt(15);
                System.out.println(msg+" "+i);
                return i;
            }
        });
        System.in.read();
    }
}
