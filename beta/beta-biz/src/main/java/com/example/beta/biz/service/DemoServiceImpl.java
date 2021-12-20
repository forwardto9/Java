package com.example.beta.biz.service;

import com.example.beta.biz.DemoService;
import com.example.beta.dao.UserDO;
import com.example.beta.dao.UserDOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private UserDOMapper userDOMapper;

    @Override
    public String test() {
        UserDO user = userDOMapper.selectByPrimaryKey(1);
        return user.toString();
    }
}
