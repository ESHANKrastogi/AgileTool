package com.opensource.jiangbiao.agileTool.dao;

import com.opensource.jiangbiao.agileTool.entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import java.util.List;

/**
 * @author Jiang Biao
 * @date 11/9/2017 9:08 PM
 */
@Repository
@Table(name = "aTUser")
@Qualifier("UserDao")
public interface UserDao extends CrudRepository<User,Long>{

    public User findUserByAccount(String account);

    public List<User> findAll();

    public User save(User user);

    public void delete(Long id);

    public User findOne(Long id);

    public boolean exists(Long id);

}
