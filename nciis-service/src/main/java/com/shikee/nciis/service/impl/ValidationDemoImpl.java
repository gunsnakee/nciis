package com.shikee.nciis.service.impl;

import com.shikee.nciis.service.api.ValidationDemo;
import com.shikee.nciis.service.pojo.ValidationDemoParameter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by Administrator on 14-10-18.
 */
public class ValidationDemoImpl implements ValidationDemo {
    @Override
    public void save(ValidationDemoParameter validationDemoParameter) {
        System.out.println("ValidationDemoImpl save...");
    }

    @Override
    public void update(ValidationDemoParameter validationDemoParameter) {
        System.out.println("ValidationDemoImpl update...");
    }

    @Override
    public void delete(@Min(1) int id, @NotNull @Pattern(regexp = "^[a-zA-Z]+$") @Size(min = 2, max = 18) String op) {
        System.out.println("ValidationDemoImpl delete...");
    }
}
