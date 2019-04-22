package com.example.transfer.service.two.impl;
import com.example.transfer.dao.two.RoleSysMapper;
import com.example.transfer.entity.two.RoleSys;
import com.example.transfer.service.two.RoleSysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class RoleSysServiceImpl implements RoleSysService {
    @Autowired
    RoleSysMapper roleSysMapper;
    @Override
    public int insert(RoleSys roleSys) {
        int addCount=roleSysMapper.insert(roleSys);
        //int i=1/0;
        return addCount;
    }
    @Override
    public int insertA(RoleSys roleSys) {
        return roleSysMapper.insertA(roleSys);
    }
}