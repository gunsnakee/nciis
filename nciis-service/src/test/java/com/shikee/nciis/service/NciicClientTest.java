package com.shikee.nciis.service;

import junit.framework.TestCase;

public class NciicClientTest extends TestCase {

    public void testExecuteClient() throws Exception {
        String con="<?xml version=\"1.0\" encoding=\"UTF-8\" ?><ROWS><INFO><SBM>123456789</SBM></INFO><ROW><GMSFHM>450603198508150010</GMSFHM><XM>吴家武</XM></ROW><ROW FSD=\"450603\" YWLX=\"查询账户\" ><GMSFHM></GMSFHM><XM></XM></ROW><ROW FSD=\"\" YWLX=\"\"><GMSFHM></GMSFHM><XM></XM></ROW></ROWS>";
        new NciicClient().executeClient("NciicServices","d",con);
    }
}