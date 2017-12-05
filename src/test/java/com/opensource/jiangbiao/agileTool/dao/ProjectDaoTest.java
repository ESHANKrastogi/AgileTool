package com.opensource.jiangbiao.agileTool.dao;

import com.opensource.jiangbiao.agileTool.entity.Project;
import com.opensource.jiangbiao.agileTool.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Jiang Biao
 * @date 11/16/2017 1:38 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectDaoTest {

    @Autowired
    ProjectDao projectDao;

    @Autowired
    UserDao userDao;

    @Test
    public void getProjectByOwner() throws Exception {
        User user= userDao.findOne(1L);
        List<Project> projects = projectDao.findProjectByOwner(user);
    }

    @Test
    public void getProjectByTitle() throws Exception {
        Project project = projectDao.findProjectByName("Test");
    }

    @Test
    public void save() throws Exception {
        User user = userDao.findUserByAccount("jiangbiao");
        User user2 = userDao.findUserByAccount("jiangbiao2");
        List<User> member = new ArrayList<>();
        member.add(user2);
        Project project=new Project();
        project.setOwner(user);
        project.setDescription("Test project");
        project.setName("Test1");
        project.setStartTime(new Date());
        project.setEndTime(new Date());
        project.setMember(member);
        projectDao.save(project);
    }

    @Test
    public void delete() throws Exception {

        projectDao.delete((long) 4);
    }

    @Test
    public void findOne() throws Exception {
        //save();
        Project project = projectDao.findOne(12L);
        List<User> members = project.getMember();
    }

    @Test
    public void exists() throws Exception {

        boolean isExists = projectDao.exists(1L);

    }

}