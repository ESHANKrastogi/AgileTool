package com.opensource.jiangbiao.agileTool.entity.vo;

import com.opensource.jiangbiao.agileTool.entity.Issue;
import com.opensource.jiangbiao.agileTool.entity.Project;
import com.opensource.jiangbiao.agileTool.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiang Biao
 * @date 11/16/2017 8:24 PM
 */
public class ProjectVO {

    private Long id;

    private String name;

    private String description;

    private String startTime;

    private String endTime;

    private List<UserDTO> member;

    private UserVO owner;

    private List<Issue> issues;

    private class UserDTO{
        private Long id;
        private String userName;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public List<UserDTO> getMember() {
        return member;
    }

    public void setMember(List<UserDTO> member) {
        this.member = member;
    }


    public List<Issue> getIssues() {
        return issues;
    }

    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }

    public UserVO getOwner() {
        return owner;
    }

    public void setOwner(UserVO owner) {
        this.owner = owner;
    }

    public void copy(Project project, String startTime, String endTime){
        this.setId(project.getId());
        this.setName(project.getName());
        this.setDescription(project.getDescription());
        this.setStartTime(startTime);
        this.setEndTime(endTime);
        UserVO userVO = new UserVO();
        userVO.copy(project.getOwner());
        this.setOwner(userVO);
        this.setIssues(project.getIssues());
        List<UserDTO> members =new ArrayList<>();
        for(User user:project.getMember()){
            UserDTO userDTO=new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setUserName(user.getAccount());
        }
        this.setMember(members);
    }
}
