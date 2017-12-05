package com.opensource.jiangbiao.agileTool.entity.vo;

import com.opensource.jiangbiao.agileTool.entity.User;
import com.opensource.jiangbiao.agileTool.enums.Role;
import com.opensource.jiangbiao.agileTool.enums.UserState;

/**
 * @author Jiang Biao
 * @date 11/19/2017 5:49 PM
 */
public class UserVO {

    private Long id;

    private String firstName;

    private String lastName;

    private String password;

    private String account;

    private Role role;

    private UserState userState;

    public void copy(User user){
        this.setId(user.getId());
        this.setFirstName(user.getFirstName());
        this.setLastName(user.getLastName());
        this.setPassword(user.getPassword());
        this.setAccount(user.getAccount());
        this.setRole(user.getRole());
        this.setUserState(user.getUserState());
    }

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

    @Override
    public String toString() {
        return "UserVO{" +
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
