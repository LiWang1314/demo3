package com.example.transfer.dao.one;

import com.example.transfer.entity.one.User;
import com.example.transfer.mappers.MyMapper;

public interface UserMapper extends MyMapper<User> {
    int insertA(User user);
}