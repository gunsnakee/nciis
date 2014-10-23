package com.shikee.nciis.consumer;

import com.shikee.nciis.pojo.TwoTuple;
import com.shikee.nciis.service.api.HelloService;
import com.shikee.nciis.service.api.Notify;
import com.shikee.nciis.service.impl.NotifyImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Random;

/**
 * Created by Administrator on 2014/10/20.
 */
public class SayHelloInjvmConsumer {


    static ClassPathXmlApplicationContext getContext(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"say-hello-consumer-injvm.xml"});
        context.start();
        return context;
    }

    static TwoTuple<HelloService,NotifyImpl> getServices(){
        ClassPathXmlApplicationContext context = getContext();
        return new TwoTuple<HelloService, NotifyImpl>((HelloService) context.getBean("sayHelloService"),(NotifyImpl) context.getBean("notify"))  ;
    }

    public static void main(String[] args) throws Exception {
        TwoTuple<HelloService,NotifyImpl> aa = getServices();

        Random r = new Random(47);

        for(int i=0;i<100;i++){
            System.out.println(aa.getFirst().sayHello(r.nextInt(10)+""));
        }


       /* NotifyImpl notify = aa.getSecond();
        for(int i=0;i<10;i++){
            if(notify.errors.containsKey("wujw")){
                Throwable throwable = notify.errors.get("wujw");
                throwable.printStackTrace();
                break;
            }else{
                if(notify.ret.containsKey("wujw")){
                    System.out.println(notify.ret.get("wujw"));
                    break;
                }else {
                    Thread.sleep(200);
                }
            }

        }*/


    }
}
