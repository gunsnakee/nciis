package com.shikee.nciis.service;

import org.codehaus.xfire.client.Client;
import org.codehaus.xfire.transport.http.CommonsHttpMessageSender;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2014/10/15.
 */
public class NciisService implements NciisInterf {
    @Override
    public String getUser(String userName, String userNo)  {


        String license = "D:/tt";
        String con="<?xml version=\"1.0\" encoding=\"UTF-8\" ?><ROWS><INFO><SBM>******</SBM></INFO><ROW><GMSFHM>公民身份号码</GMSFHM><XM>姓名</XM></ROW><ROW FSD=” **” YWLX=” **” ><GMSFHM>XXXXXX</GMSFHM><XM>XXXXXX</XM></ROW><ROW FSD=” **” YWLX=”**”><GMSFHM>XXXXXX</GMSFHM><XM>XXXXXX</XM></ROW></ROWS>";
        try {
            new NciicClient().executeClient("NciicServices", license , con);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return "test";
    }
}
