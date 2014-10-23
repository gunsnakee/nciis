package com.shikee.nciis.service.api;

import com.shikee.nciis.service.impl.ValidationDemoImpl;
import com.shikee.nciis.service.pojo.ValidationDemoParameter;
import junit.framework.TestCase;

public class ValidationDemoTest extends TestCase {

    public void testSave() throws Exception {

        ValidationDemoParameter validationDemoParameter = new ValidationDemoParameter();
        new ValidationDemoImpl().save(validationDemoParameter);

    }

    public void testUpdate() throws Exception {

    }

    public void testDelete() throws Exception {

    }
}