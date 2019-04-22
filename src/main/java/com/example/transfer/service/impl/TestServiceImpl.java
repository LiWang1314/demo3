package com.example.transfer.service.impl;

import com.example.transfer.entity.one.User;
import com.example.transfer.entity.two.RoleSys;
import com.example.transfer.service.TestService;
import com.example.transfer.service.one.UserService;
import com.example.transfer.service.two.RoleSysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Auther: liwang
 * @Date: 2019/4/16 13:31
 * @Description:
 */
@Transactional
@Service
public class TestServiceImpl implements TestService{
    @Autowired
    UserService userService;
    @Autowired
    RoleSysService roleSysService;
     public  void test(){
        User user=new User();
         user.setName("admin");
         int add1=userService.insert(user);
         System.out.println("dataSource1,通用insert:"+add1);

         RoleSys roleSys=new RoleSys();
         roleSys.setRoleName("admin");
         int add2=roleSysService.insert(roleSys);
         System.out.println("dataSource2,通用insert:"+add2);
         int i=1/0;
    }
}
