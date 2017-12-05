package com.opensource.jiangbiao.agileTool.entity;



import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author Jiang Biao
 * @date 11/9/2017 3:34 PM
 */
@Entity
@Table(name = "project",uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
public class Project {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 20,nullable = false)
    private String name;


    @Column(name = "description",columnDefinition = "TEXT")
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;

    @ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinTable(
            name = "pro_user",
            joinColumns = @JoinColumn(name="project_Id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="user_Id",referencedColumnName = "id")
    )
    private List<User> member;


    @ManyToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "owner_Id")
    private User owner;

    @OneToMany(cascade = {CascadeType.PERSIST})
    @JoinColumn(name="project_Id")
    private List<Issue> issues;


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

    public List<User> getMember() {
        return member;
    }

    public void setMember(List<User> member) {
        this.member = member;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<Issue> getIssues() {
        return issues;
    }

    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }


    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", member=" + member +
                ", owner=" + owner +
                ", issues=" + issues +
                '}';
    }
}
