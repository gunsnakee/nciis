package com.shikee.nciis.service;

import com.shikee.nciis.interf.NciisInterf;
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


        StringBuffer con = new StringBuffer();
        String condition = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?> \n" +
                "<ROWS><INFO><SBM>******</SBM></INFO><ROW><GMSFHM>"+userNo+"\n" +
                "</GMSFHM><XM>"+userName+"</XM></ROW><ROW FSD=” **” YWLX=” **” > \n" +
                "<GMSFHM>XXXXXX</GMSFHM><XM>XXXXXX</XM></ROW><ROW FSD=” **” YWLX=” \n" +
                "**”><GMSFHM>XXXXXX</GMSFHM><XM>XXXXXX</XM></ROW></ROWS>";
        BufferedReader bf = null;
        String code  = null;
        try {
            bf = new BufferedReader(new FileReader("D:\\公安接口文件/授权文件_南宁一站网网络技术有限公司_nnyznnyz48078_1112.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            code= bf!=null?  bf.readLine():"";
        } catch (IOException e) {
            e.printStackTrace();
        }

        Client client = null;
        try {
            client = new Client(new URL( "https://api.nciic.com.cn/nciic_ws/services/NciicServices?wsdl"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Object[] results = new Object[0];
        //压缩传输
        client.setProperty(CommonsHttpMessageSender.GZIP_ENABLED,
                Boolean.TRUE);
        //忽略超时
        client.setProperty(CommonsHttpMessageSender.DISABLE_EXPECT_CONTINUE, "1");
        client.setProperty(CommonsHttpMessageSender.HTTP_TIMEOUT, "0");
        try {
            results = client.invoke("nciicGetCondition", new Object[]{code});
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(results[0]);
        return "test";
    }
}
