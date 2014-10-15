package com.shikee.nciis.service;

import junit.framework.TestCase;

public class NciisServiceTest extends TestCase {

    public void testGetUser() throws Exception {
        new NciisService().getUser("dfdf","sfdsf");
    }
}