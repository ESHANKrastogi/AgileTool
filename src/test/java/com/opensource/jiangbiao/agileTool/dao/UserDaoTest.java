package com.opensource.jiangbiao.agileTool.dao;

import com.opensource.jiangbiao.agileTool.entity.User;
import com.opensource.jiangbiao.agileTool.enums.Role;
import com.opensource.jiangbiao.agileTool.enums.UserState;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Jiang Biao
 * @date 11/16/2017 3:09 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Autowired
    UserDao userDao;

    @Test
    public void getUserbyAccount() throws Exception {
    }

    @Test
    public void findAll() throws Exception {
        List<User> users = userDao.findAll();
    }

    @Test
    public void save() throws Exception {
        User user =new User();
        user.setAccount("jiangbiao");
        user.setFirstName("biao");
        user.setLastName("jiang");
        user.setPassword("123");
        user.setRole(Role.PROJECT_MANAGER);
        user.setUserState(UserState.ACTIVE);
        userDao.save(user);

    }
    @Test
    public void save2() throws Exception{
        User user =new User();
        user.setAccount("jiangbiao2");
        user.setFirstName("biao2");
        user.setLastName("jiang");
        user.setPassword("123");
        user.setRole(Role.PROJECT_MANAGER);
        user.setUserState(UserState.ACTIVE);
        userDao.save(user);
    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void findOne() throws Exception {
        User user= userDao.findUserByAccount("jiangbiao");
    }

    @Test
    public void exists() throws Exception {
    }

}