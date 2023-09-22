package com.example.springboot2.service;

import com.example.springboot2.mapper.UserMapper;
import com.example.springboot2.pojo.User;
import com.example.springboot2.pojo.UserExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    public void insert(User user) {
        userMapper.insert(user);
    }

    public void update(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    public void delete(Integer id) {
        userMapper.deleteByPrimaryKey(id);
    }
}
