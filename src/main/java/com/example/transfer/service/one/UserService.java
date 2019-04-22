package com.example.transfer.service.one;

import com.example.transfer.entity.one.User;
import org.springframework.stereotype.Service;

/**
 * @Auther: liwang
 * @Date: 2019/4/15 11:12
 * @Description:
 */
public interface UserService {
     int insert(User user);
     int insertA(User user);
}
