package com.example.transfer.controller;
import com.example.common.exception.ServiceException;
import com.example.transfer.entity.one.User;
import com.example.transfer.entity.two.RoleSys;
import com.example.transfer.service.TestService;
import com.example.transfer.service.one.UserService;
import com.example.transfer.service.two.RoleSysService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * @Auther: liwang
 * @Date:
 * @Description:
 */
//delete from test.user_sys;
//delete from test1.role_sys;
@Api(value="测试controller")
@Controller
public class Test {

    @Autowired
    UserService userService;
    @Autowired
    RoleSysService roleSysService;
    @Autowired
    TestService testService;
    @Autowired
    @Qualifier("jdbcTemplateOne")
    JdbcTemplate jdbcTemplateOne;
    @Autowired
    @Qualifier("jdbcTemplateTwo")
    JdbcTemplate jdbcTemplateTwo;
    /*
    @ApiOperation() 用于方法；表示一个http请求的操作
    value用于方法描述
    notes用于提示内容
    tags可以重新分组（视情况而用）*/
    @ApiOperation(value="测试通用mapper",notes="提示内容")
    /*@ApiParam() 用于方法，参数，字段说明；表示对参数的添加元数据（说明或是否必填等）
    name–参数名
    value–参数说明
    required–是否必填*/
    @GetMapping("/test1")
    @ResponseBody
    public void test1(@ApiParam(name="id",value="主键ID",required=false)String id){
        User user=new User();
        user.setName("admin");
        int add1=userService.insert(user);
        System.out.println("dataSourceOne,通用:"+add1);
        RoleSys roleSys=new RoleSys();
        roleSys.setRoleName("admin");
        int add2=roleSysService.insert(roleSys);
        System.out.println("dataSourceTwo,通用:"+add2);
    }
    //测试自定义mybatis **.xml
    @GetMapping("/test2")
    @ResponseBody
    public void test2() throws Exception{
        User user=new User();
        user.setName("2");
        int add1=userService.insertA(user);
        System.out.println("dataSourceOne:"+add1);
        RoleSys roleSys=new RoleSys();
        roleSys.setRoleName("2");
        int add2=roleSysService.insertA(roleSys);
        System.out.println("dataSourceTwo:"+add2);
    }

    //测试jta事务
    @GetMapping("/test")
    @ResponseBody
    public void test() throws Exception{
        testService.test();
    }
    //测试JdbcTemplate
    @GetMapping("/test3")
    @ResponseBody
    public void test3(){
        String sql1 = " INSERT INTO user_sys(`name`) VALUES (?)";
        int add1 = jdbcTemplateOne.update(sql1,"来");
        System.out.println("dataSourceOne,JdbcTemplate:"+add1);
        String sql2 = "INSERT INTO role_sys(role_name) VALUES (?)";
        int add2 = jdbcTemplateTwo.update(sql2,"去");
        System.out.println("dataSourceTwo,JdbcTemplate:"+add2);
    }

    @GetMapping("/test4")
    @ResponseBody
    public void test4(){
       throw new ServiceException("测试自定义异常");
    }
    @GetMapping("/test5")
    @ResponseBody
    @ApiOperation(value = "swagger测试", notes = "")
    public void test5(@RequestBody User user){
        throw new ServiceException("测试自定义异常");
    }
}
