package com.opensource.jiangbiao.agileTool.entity;

import com.opensource.jiangbiao.agileTool.enums.Role;
import com.opensource.jiangbiao.agileTool.enums.UserState;

import javax.persistence.*;
import java.util.List;

/**
 * @author Jiang Biao
 * @date 11/9/2017 3:34 PM
 */
@Entity
@Table(name="atUser",uniqueConstraints = {@UniqueConstraint(columnNames = "account")})
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @Column(length = 20,nullable = false)
    private String firstName;
    @Column(length = 20,nullable = false)
    private String lastName;
    @Column(length = 100,nullable = false)
    private String password;
    @Column(length = 50,nullable = false)
    private String account;
    @Column(length = 50,nullable = false)
    private Role role;
    @Column(length = 50,nullable = false)
    private UserState userState;

    @ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY,mappedBy = "member")
    private List<Project> projects;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public UserState getUserState() {
        return userState;
    }

    public void setUserState(UserState userState) {
        this.userState = userState;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", account='" + account + '\'' +
                ", role=" + role +
                ", userState=" + userState +
                '}';
    }
}
