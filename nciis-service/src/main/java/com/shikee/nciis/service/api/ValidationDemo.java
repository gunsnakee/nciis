package com.shikee.nciis.service.api;

import com.shikee.nciis.service.pojo.ValidationDemoParameter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by Administrator on 2014/10/18.
 */
public interface ValidationDemo {

    @interface Save{}
    void save(ValidationDemoParameter validationDemoParameter);

    @interface Update{}
    void update(ValidationDemoParameter validationDemoParameter);

    void delete(@Min(1) int id,@NotNull @Pattern(regexp = "^[a-zA-Z]+$") @Size(min = 2,max = 18)String op);

}
