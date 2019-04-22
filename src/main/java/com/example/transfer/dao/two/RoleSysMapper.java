package com.example.transfer.dao.two;

import com.example.transfer.entity.two.RoleSys;
import com.example.transfer.mappers.MyMapper;

public interface RoleSysMapper extends MyMapper<RoleSys> {
   int insertA(RoleSys roleSys);
}