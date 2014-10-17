package com.shikee.nciis.service;

import junit.framework.TestCase;

public class NciisServiceTest extends TestCase {

    public void testGetUser() throws Exception {
        new NciisService().getUser("吴家武","450603198508150010");
    }
}