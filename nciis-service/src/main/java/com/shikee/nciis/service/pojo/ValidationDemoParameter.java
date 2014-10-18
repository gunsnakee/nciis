package com.shikee.nciis.service.pojo;

import com.shikee.nciis.service.api.ValidationDemo;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2014/10/18.
 */
public class ValidationDemoParameter implements Serializable {

    @Min(100)
    @Max(1000)
    private int id;

    @NotNull
    @Size(min=12,max = 48)
    private String name;

    @Past
    private Date loginTime;

    @Future
    private Date expireTime;

    @NotNull(groups = ValidationDemo.Save.class) // 保存时不允许为空，更新时允许为空 ，表示不更新该字段
    @Pattern(regexp = "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$")
    private String email;

}
