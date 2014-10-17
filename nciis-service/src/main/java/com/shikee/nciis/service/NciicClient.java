package com.shikee.nciis.service;


import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.httpclient.protocol.ProtocolSocketFactory;
import org.codehaus.xfire.client.Client;
import org.codehaus.xfire.client.XFireProxy;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;
import org.codehaus.xfire.transport.http.CommonsHttpMessageSender;
import org.codehaus.xfire.transport.http.EasySSLProtocolSocketFactory;
import org.codehaus.xfire.util.dom.DOMOutHandler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Proxy;
import java.net.MalformedURLException;


public class NciicClient {
    public  static  final  String  SERVICE_URL  =  "https://api.nciic.com.cn/nciic_ws/services/";
    public NciicClient() {
    }
    /**
     * @param args
     * @throws MalformedURLException
     */
    public static void main(String[] args) throws MalformedURLException {
        /**
         * 授权文件名称，如果该文件不在客户端工程根目录下，请
         * 将文件路径添加。如 C:\\1.txt
         */
        String license = "D:/tt";
        String con="<?xml version=\"1.0\" encoding=\"UTF-8\" ?><ROWS><INFO><SBM>******</SBM></INFO><ROW><GMSFHM>公民身份号码</GMSFHM><XM>姓名</XM></ROW><ROW FSD=” **” YWLX=” **” ><GMSFHM>XXXXXX</GMSFHM><XM>XXXXXX</XM></ROW><ROW FSD=” **” YWLX=”**”><GMSFHM>XXXXXX</GMSFHM><XM>XXXXXX</XM></ROW></ROWS>";
        new NciicClient().executeClient("NciicServices", license ,
                con);
    }

    public String executeClient(String serviceName, String license,
                                String condition)
            throws MalformedURLException {

        ProtocolSocketFactory easy = new EasySSLProtocolSocketFactory();
        Protocol protocol = new Protocol("https", easy, 443);
        Protocol.registerProtocol("https", protocol);
        Service serviceModel = new ObjectServiceFactory().create(
                ServiceInf.class, "NciicServices", null, null);

        ServiceInf service = (ServiceInf) new
                XFireProxyFactory().create(
                serviceModel, SERVICE_URL + serviceName);

        Client client = ((XFireProxy)
                Proxy.getInvocationHandler(service))
                .getClient();

        client.addOutHandler(new DOMOutHandler());
        //压缩传输
        client.setProperty(CommonsHttpMessageSender.GZIP_ENABLED,
                Boolean.TRUE);
        //忽略超时
        client.setProperty(CommonsHttpMessageSender.DISABLE_EXPECT_CONTINUE, "1");
        client.setProperty(CommonsHttpMessageSender.HTTP_TIMEOUT,
                "0");
/**
* 读取授权文件内容，因为授权文件为加密格式请不要对内容做任何修改
*/

        String licensecode = null;
        String result = null;
        BufferedReader in;
        try {
            in = new BufferedReader(new FileReader(license+".txt"));
            licensecode = in.readLine();
//调用核查方法
            result = service.nciicCheck(licensecode, condition);
//服务条件模板获取
//result = service.nciicGetCondition(licensecode);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(result);
        return result;
    }
}
