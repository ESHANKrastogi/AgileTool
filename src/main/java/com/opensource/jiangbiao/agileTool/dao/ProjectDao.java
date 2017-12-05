package com.opensource.jiangbiao.agileTool.dao;

import com.opensource.jiangbiao.agileTool.entity.Project;
import com.opensource.jiangbiao.agileTool.entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Table;
import java.util.List;

/**
 * @author Jiang Biao
 * @date 11/9/2017 9:08 PM
 */
@Repository
@Table(name = "project")
@Qualifier("ProjectDao")
public interface ProjectDao extends CrudRepository<Project,Long>{


    public List<Project> findProjectByOwner(User user);


    public Project findProjectByName(String name);


    public Project save(Project project);


    public void delete(Long id);

    public Project findOne(long id);

    public boolean exists(Long id);
}
