package com.shikee.nciis.service.impl;

import com.shikee.nciis.service.api.NciisInterf;
import com.shikee.nciis.service.tool.NciicClient;

import java.net.MalformedURLException;
import java.util.Date;

/**
 * Created by Administrator on 2014/10/15.
 */
public class NciisServiceXfire implements NciisInterf {
    @Override
    public String getUser(String userName, String userNo)  {

        String ss = null;
        String con="<?xml version=\"1.0\" encoding=\"UTF-8\" ?><ROWS><INFO><SBM>123456789</SBM></INFO><ROW><GMSFHM>"+userNo+"</GMSFHM><XM>"+userName+"</XM></ROW><ROW FSD=\"450603\" YWLX=\"查询账户\" ><GMSFHM></GMSFHM><XM></XM></ROW><ROW FSD=\"\" YWLX=\"\"><GMSFHM></GMSFHM><XM></XM></ROW></ROWS>";
        try {
           ss =  NciicClient.executeClient("NciicServices", con);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return ss+" "+(new Date());
    }
}
