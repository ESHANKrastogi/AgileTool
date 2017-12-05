package com.opensource.jiangbiao.agileTool.service;

import com.opensource.jiangbiao.agileTool.entity.Issue;
import com.opensource.jiangbiao.agileTool.entity.Project;
import com.opensource.jiangbiao.agileTool.entity.vo.IssueVO;
import com.opensource.jiangbiao.agileTool.entity.vo.ProjectVO;
import com.opensource.jiangbiao.agileTool.entity.vo.UserVO;
import com.opensource.jiangbiao.agileTool.unified.ResponseBean;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiang Biao
 * @date 11/9/2017 9:09 PM
 */
public interface ProjectService {

    public ResponseBean<List<ProjectVO>> getAllProject(HttpSession session);
    public ResponseBean<List<UserVO>> getProjectMember(Long id);
    public ResponseBean<Boolean> addProject(String name, String description, String startTime, String endTime, long[] member, HttpSession session);
    public ResponseBean<Boolean> deleteProject(Long projectId);


    public ResponseBean<Boolean> addIssue(Long projectId,String title,String description,
                                          Long assigneesId,String index,Long effort,String startTime,String endTime);
    public ResponseBean<Boolean> deleteIssue(Long projectId,Long issueId);
    public ResponseBean<List<IssueVO>> getAllIssue(Long projectId);



}
