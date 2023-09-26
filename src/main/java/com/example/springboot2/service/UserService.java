package com.example.springboot2.service;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjUtil;
import com.example.springboot2.domain.User;
import com.example.springboot2.domain.UserExample;
import com.example.springboot2.mapper.UserMapper;

import com.example.springboot2.req.UserQueryReq;
import com.example.springboot2.req.UserSaveReq;
import com.example.springboot2.req.UserUpdateReq;
import com.example.springboot2.resp.PageResp;
import com.example.springboot2.resp.UserQueryResp;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class UserService {

    @Resource
    private UserMapper userMapper;
    public PageResp<UserQueryResp> queryList(UserQueryReq req) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        if (ObjUtil.isNotNull(req.getName())) {
            criteria.andNameEqualTo(req.getName());
        }
        log.info("查询页码：{}", req.getPage());
        log.info("每页条数：{}", req.getSize());

        PageHelper.startPage(req.getPage(), req.getSize());
        List<User> userList = userMapper.selectByExample(userExample);

        PageInfo<User> pageInfo = new PageInfo<>(userList);
        log.info("总行数：{}", pageInfo.getTotal());
        log.info("总页数：{}", pageInfo.getPages());

        List<UserQueryResp> list = BeanUtil.copyToList(userList, UserQueryResp.class);

        PageResp<UserQueryResp> pageResp = new PageResp<>();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);
        return pageResp;
    }

    public void save(UserSaveReq req){
        User user = BeanUtil.copyProperties(req,User.class);
        user.setName(req.getName());
        user.setAge(req.getAge());
        userMapper.insert(user);
    }
    public void update(UserUpdateReq req) {
        User user = BeanUtil.copyProperties(req,User.class);
        user.setId(req.getId());
        if(ObjUtil.isNotNull(userMapper.selectByPrimaryKey(req.getId()))){
            user.setName(req.getName());
            user.setAge(req.getAge());
            userMapper.updateByPrimaryKeySelective(user);
        }
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
