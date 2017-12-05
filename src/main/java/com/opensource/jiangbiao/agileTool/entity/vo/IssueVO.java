package com.opensource.jiangbiao.agileTool.entity.vo;

import com.opensource.jiangbiao.agileTool.entity.Issue;
import com.opensource.jiangbiao.agileTool.enums.Index;

import java.util.Date;

/**
 * @author Jiang Biao
 * @date 11/20/2017 9:35 PM
 */
public class IssueVO {


    private int id;

    private String title;


    private String description;

    private UserVO assigness;

    private Index index;

    private Long effort;

    private Date startTime;

    private Date endTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserVO getAssigness() {
        return assigness;
    }

    public void setAssigness(UserVO assigness) {
        this.assigness = assigness;
    }

    public Index getIndex() {
        return index;
    }

    public void setIndex(Index index) {
        this.index = index;
    }

    public Long getEffort() {
        return effort;
    }

    public void setEffort(Long effort) {
        this.effort = effort;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }


    public void copy(Issue issue){
        this.setTitle(issue.getTitle());
        this.setId(issue.getId());
        this.setDescription(issue.getDescription());
        this.setEffort(issue.getEffort());
        this.setStartTime(issue.getStartTime());
        this.setEndTime(issue.getEndTime());
        UserVO userVO = new UserVO();
        userVO.copy(issue.getAssignees());
        this.setAssigness(userVO);
    }
}
