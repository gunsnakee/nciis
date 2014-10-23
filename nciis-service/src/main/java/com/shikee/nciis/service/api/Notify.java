package com.shikee.nciis.service.api;

/**
 * Created by Administrator on 2014/10/21.
 */
public interface Notify {
    void onreturn(String welcomeMsg,String user);
    void onthrow(Throwable tx,String user);
}
