package com.opensource.jiangbiao.agileTool.service;

import com.opensource.jiangbiao.agileTool.dao.ProjectDao;
import com.opensource.jiangbiao.agileTool.dao.UserDao;
import com.opensource.jiangbiao.agileTool.entity.Issue;
import com.opensource.jiangbiao.agileTool.entity.Project;
import com.opensource.jiangbiao.agileTool.entity.User;
import com.opensource.jiangbiao.agileTool.entity.vo.IssueVO;
import com.opensource.jiangbiao.agileTool.entity.vo.ProjectVO;
import com.opensource.jiangbiao.agileTool.entity.vo.UserVO;
import com.opensource.jiangbiao.agileTool.enums.Index;
import com.opensource.jiangbiao.agileTool.unified.ResponseBean;
import com.opensource.jiangbiao.agileTool.unified.ResponseCode;
import com.opensource.jiangbiao.agileTool.utility.TimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Jiang Biao
 * @date 11/9/2017 9:10 PM
 */
@Service
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    ProjectDao projectDao;

    @Autowired
    UserDao userDao;

    @Override
    public ResponseBean<List<ProjectVO>> getAllProject(HttpSession session) {
        User user =(User) session.getAttribute("user");
        ResponseBean<List<ProjectVO>> msg=new ResponseBean<>();
        List<Project> projects=projectDao.findProjectByOwner(user);
        List<ProjectVO> projectVOS =new ArrayList<>();
        for(Project project:projects){
            ProjectVO projectVO=new ProjectVO();
            projectVO.copy(project,TimeFormat.dateToString(project.getStartTime())
                    ,TimeFormat.dateToString(project.getEndTime()));
            projectVOS.add(projectVO);
        }
        msg.setData(projectVOS);
        msg.setStatus(ResponseCode.OK);
        return msg;
    }

    @Override
    public ResponseBean<List<UserVO>> getProjectMember(Long id) {
        ResponseBean<List<UserVO>> msg=new ResponseBean<>();
        List<UserVO> membersVO = new ArrayList<>();
        Project project = projectDao.findOne(id);
        List<User> memebers = project.getMember();
        for(User user:memebers){
            UserVO userVO=new UserVO();
            userVO.setId(user.getId());
            userVO.setFirstName(user.getFirstName());
            userVO.setLastName(user.getLastName());
            membersVO.add(userVO);
        }
        msg.setData(membersVO);
        msg.setStatus(ResponseCode.OK);
        return msg;
    }

    @Override
    public ResponseBean<Boolean> addProject(String name, String description, String startTime, String endTime, long[] member, HttpSession session) {
        ResponseBean<Boolean> msg=new ResponseBean<>();
        User owner = (User)session.getAttribute("user");
        if(projectDao.findProjectByName(name)!=null){
            msg.setData(false);
            msg.setStatus(ResponseCode.PROJECT_EXIST);
            return msg;
        }
        Project project=new Project();
        project.setName(name);
        project.setDescription(description);
        project.setStartTime(TimeFormat.stringToDate(startTime));
        project.setEndTime(TimeFormat.stringToDate(endTime));
        project.setOwner(owner);
        List<User> members =new ArrayList<>();
        for(Long i:member){
            User user = userDao.findOne(i);
            members.add(user);
        }
        project.setMember(members);
        projectDao.save(project);
        msg.setStatus(ResponseCode.OK);
        msg.setData(true);
        return msg;
    }

    @Override
    public ResponseBean<Boolean> deleteProject(Long projectId) {
        ResponseBean<Boolean> msg=new ResponseBean<>();
        projectDao.delete(projectId);
        msg.setData(true);
        msg.setStatus(ResponseCode.OK);
        return msg;
    }

    @Override
    public ResponseBean<Boolean> addIssue(Long projectId, String title, String description, Long assigneesId, String index, Long effort, String startTime, String endTime) {
        ResponseBean<Boolean> msg=new ResponseBean<>();
        Project project = projectDao.findOne(projectId);
        User assignees = userDao.findOne(assigneesId);
        Issue issue=new Issue();
        issue.setAssignees(assignees);
        issue.setTitle(title);
        issue.setDescription(description);
        issue.setEffort(effort);
        issue.setIndex(Index.valueOf(index));
        issue.setStartTime(TimeFormat.stringToDate(startTime));
        issue.setEndTime(TimeFormat.stringToDate(endTime));
        project.getIssues().add(issue);
        projectDao.save(project);
        msg.setData(true);
        msg.setStatus(ResponseCode.OK);
        return msg;
    }

    //    @Override
//    public ResponseBean<Boolean> addIssue(Long projectId, Issue issue) {
//        ResponseBean<Boolean> msg = new ResponseBean<>();
//        Project project= projectDao.findOne(projectId);
//        project.getIssues().add(issue);
//        projectDao.save(project);
//        msg.setData(true);
//        msg.setStatus(ResponseCode.OK);
//        return msg;
//    }

    @Override
    public ResponseBean<Boolean> deleteIssue(Long projectId, Long issueId) {
        ResponseBean<Boolean> msg=new ResponseBean<>();
        Project project=projectDao.findOne(projectId);
        List<Issue> issues = project.getIssues();
        return msg;
    }

    @Override
    public ResponseBean<List<IssueVO>> getAllIssue(Long projectId) {
        Project project=projectDao.findOne(projectId);
        List<Issue> issues=project.getIssues();
        List<IssueVO> issueVOS =new ArrayList<>();
        ResponseBean<List<IssueVO>> msg=new ResponseBean<>();
        for(Issue issue:issues){
            IssueVO issueVO=new IssueVO();
            issueVO.copy(issue);
            issueVOS.add(issueVO);
        }
        msg.setData(issueVOS);
        msg.setStatus(ResponseCode.OK);
        return msg;
    }


}
