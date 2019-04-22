package com.example.transfer.service.one.impl;
import com.example.transfer.dao.one.UserMapper;
import com.example.transfer.entity.one.User;
import com.example.transfer.service.one.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @Auther: liwang
 * @Date: 2019/4/15 11:18
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;
   @Override
    public int insert(User user) {
       int addCount=userMapper.insert(user);
       //int i=1/0;
       return addCount;
    }

    @Override
    public int insertA(User user) {
        return userMapper.insertA(user);
    }
}
