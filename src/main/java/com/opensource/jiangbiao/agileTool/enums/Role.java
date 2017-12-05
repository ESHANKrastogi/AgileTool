package com.opensource.jiangbiao.agileTool.enums;

/**
 * @author Jiang Biao
 * @date 11/9/2017 3:35 PM
 */
public enum Role {

    PROJECT_MEMBER(1),
    PROJECT_OWNER(2),
    PROJECT_MANAGER(3);
    private int role;
    Role(int role){
        this.role = role;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
