package com.example.springboot2.service;


import com.example.springboot2.domain.User;
import com.example.springboot2.domain.UserExample;
import com.example.springboot2.mapper.UserMapper;

import com.example.springboot2.req.UserReq;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class UserService {

    @Resource
    private UserMapper userMapper;
    public Object queryList(Map<String, Object> req) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        if(req.containsKey("name")){
            String name = (String) req.get("name");
            criteria.andNameEqualTo(name);
        }

        List<User> list = userMapper.selectByExample(userExample);

        PageHelper.startPage(1, 10);

        PageInfo<User> pageInfo = new PageInfo<>(list);

        Map<String, Object> map = new HashMap<>();
        map.put("list",list);
        map.put("total",pageInfo.getTotal());
        return map;
    }

    public void insert(UserReq req) {
        User user = new User();
        user.setName(req.getName());
        user.setAge(req.getAge());
        userMapper.insert(user);
    }

    public void update(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    public void delete(Integer id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Transactional
    public void transactional(){
        //1. 新增
        //2. 异常
        //3. 修改
        //4. 事务要么都成功，要么都失败,因为中间过程中有异常，所以会回滚,
        User user = new User();
        user.setName("ccc");
        user.setAge(10);
        userMapper.insert(user);

        int newId = 100 / 0; //异常
        log.info("newId"+newId);
        User user2 = new User();
        user2.setId(1);
        user2.setName("111111");
        userMapper.updateByPrimaryKeySelective(user2);
    }
}
