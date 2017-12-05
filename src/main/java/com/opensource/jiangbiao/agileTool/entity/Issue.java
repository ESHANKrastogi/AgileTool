package com.opensource.jiangbiao.agileTool.entity;

import com.opensource.jiangbiao.agileTool.enums.Index;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Jiang Biao
 * @date 11/9/2017 3:34 PM
 */
@Entity
@Table(name = "issue",uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})})
public class Issue {

    @Id
    @GeneratedValue
    private int id;

    @Column(length = 200,nullable =  false)
    private String title;

    @Type(type = "text")
    @Column(name = "description")
    private String description;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name="assignees_id")
    private User assignees;

    @Column(name = "issue_index",length = 20)
    @Enumerated(EnumType.STRING)
    private Index index;
    @Column(nullable = true)
    private Long effort;

    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
    @Temporal(TemporalType.TIMESTAMP)
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

    public User getAssignees() {
        return assignees;
    }

    public void setAssignees(User assignees) {
        this.assignees = assignees;
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



}
