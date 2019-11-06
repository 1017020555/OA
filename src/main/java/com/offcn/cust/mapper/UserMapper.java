package com.offcn.cust.mapper;

import com.offcn.cust.bean.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    List<User> getGoodsList();
}
