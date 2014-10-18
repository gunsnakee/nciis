package com.shikee.nciis.service.tool;


import com.shikee.nciis.service.tool.ServiceInf;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.httpclient.protocol.ProtocolSocketFactory;
import org.apache.commons.io.IOUtils;
import org.codehaus.xfire.client.Client;
import org.codehaus.xfire.client.XFireProxy;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;
import org.codehaus.xfire.transport.http.CommonsHttpMessageSender;
import org.codehaus.xfire.transport.http.EasySSLProtocolSocketFactory;
import org.codehaus.xfire.util.dom.DOMOutHandler;

import java.io.*;
import java.lang.reflect.Proxy;
import java.net.MalformedURLException;
import java.util.List;


public class NciicClient {

    private static final String SERVICE_URL  = "https://api.nciic.com.cn/nciic_ws/services/";
    private static final String LICENSE_FILE = "D:/公安接口文件/nnyz.txt";
    private static String LICENSE_CODE = null;

    static {
        try {
            /**
             * 读取授权文件内容，因为授权文件为加密格式请不要对内容做任何修改
             */
            List<String> lines = IOUtils.readLines(new FileInputStream(LICENSE_FILE), "UTF-8");
            StringBuffer stringBuffer = new StringBuffer();
            for (String line:lines){
                stringBuffer.append(line);
            }
            LICENSE_CODE = stringBuffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public NciicClient() {

    }

    public static String executeClient(String serviceName, String condition)
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


        String result = null;
        result = service.nciicCheck(LICENSE_CODE, condition);
        System.out.println(result);
        return result;
    }
}
