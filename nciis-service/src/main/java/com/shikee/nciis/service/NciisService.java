package com.shikee.nciis.service;

import org.codehaus.xfire.client.Client;
import org.codehaus.xfire.transport.http.CommonsHttpMessageSender;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

/**
 * Created by Administrator on 2014/10/15.
 */
public class NciisService implements NciisInterf {
    @Override
    public String getUser(String userName, String userNo)  {

        String ss = null;
        String license = "/data/nnyz";
        String con="<?xml version=\"1.0\" encoding=\"UTF-8\" ?><ROWS><INFO><SBM>123456789</SBM></INFO><ROW><GMSFHM>"+userNo+"</GMSFHM><XM>"+userName+"</XM></ROW><ROW FSD=\"450603\" YWLX=\"查询账户\" ><GMSFHM></GMSFHM><XM></XM></ROW><ROW FSD=\"\" YWLX=\"\"><GMSFHM></GMSFHM><XM></XM></ROW></ROWS>";
        try {
           ss =  new NciicClient().executeClient("NciicServices", license , con);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return ss+" "+(new Date());
    }
}
