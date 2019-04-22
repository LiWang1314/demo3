package com.example.transfer.entity.one;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@Table(name = "user_sys")
/*@ApiModel()用于类 ；表示对类进行说明，用于参数用实体类接收
value–表示对象名
description–描述*/
@ApiModel(value="user",description="对象描述")
public class User implements Serializable{
    /*@ApiModelProperty()用于方法，字段； 表示对model属性的说明或者数据操作更改
    value–字段说明
    name–重写属性名字
    dataType–重写属性类型
    required–是否必填
    example–举例说明
    hidden–隐藏*/
    @Id
    private Integer id;
    @ApiModelProperty(value="用户名",name="name",example="小明",required = true)
    private String name;

    @Column(name = "address_i")
    private String addressI;
}