package com.example.transfer.entity.two;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Table(name = "role_sys")
public class RoleSys {
    @Id
    private Integer id;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "describe_con")
    private String describeCon;
}