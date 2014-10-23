package com.shikee.nciis.service.impl;

import com.shikee.nciis.service.api.CallbackAction;
import com.shikee.nciis.service.api.CallbackService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2014/10/21.
 */
public class CallbackServiceImpl implements CallbackService {
    private Map<String, CallbackAction> listeners = new ConcurrentHashMap<String, CallbackAction>();

    public CallbackServiceImpl() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("Thread run...");
                    for (Map.Entry<String, CallbackAction> lisener : listeners.entrySet()) {
                        int i = lisener.getValue().callConsumer(getMsg(lisener.getKey()));
                        System.out.println("After do SomeThing");
                        if(i==13){
                            listeners.remove(lisener);
                        }

                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
        t.setDaemon(true);
        t.start();
    }

    @Override
    public void addListener(String key, CallbackAction callBackAction) {
        System.out.println("begin doSomething...");
        listeners.put(key, callBackAction);
    }

    private String getMsg(String key) {
        return key + " " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
