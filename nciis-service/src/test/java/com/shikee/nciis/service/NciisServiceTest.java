package com.shikee.nciis.service;

import com.shikee.nciis.service.impl.NciisServiceXfire;
import junit.framework.TestCase;

public class NciisServiceTest extends TestCase {

    public void testGetUser() throws Exception {
        new NciisServiceXfire().getUser("吴家武","450603198508150010");
    }
}