package com.shikee.nciis.service.impl;

import com.shikee.nciis.service.api.Notify;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2014/10/21.
 */
public class NotifyImpl implements Notify {
    public Map<String,String> ret = new HashMap<String, String>();
    public Map<String,Throwable> errors = new HashMap<String, Throwable>();
    @Override
    public void onreturn(String welcomeMsg, String user) {
        System.out.println("onreturn... "+user);
        ret.put(user,welcomeMsg);
    }

    @Override
    public void onthrow(Throwable tx, String user) {
        System.out.println("onthrow... "+user);
        errors.put(user,tx);
    }
}
