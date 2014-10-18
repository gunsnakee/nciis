package com.shikee.nciis.service.api;

import com.shikee.nciis.service.pojo.ValidationDemoParameter;

/**
 * Created by Administrator on 2014/10/18.
 */
public interface ValidationDemo {

    @interface Save{}
    void save(ValidationDemoParameter validationDemoParameter);

    @interface Update{}
    void update(ValidationDemoParameter validationDemoParameter);

    void delete();

}
