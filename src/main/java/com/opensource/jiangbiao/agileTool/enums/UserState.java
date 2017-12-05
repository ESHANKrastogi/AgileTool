package com.opensource.jiangbiao.agileTool.enums;

/**
 * @author Jiang Biao
 * @date 11/9/2017 3:42 PM
 */
public enum UserState {

    ACTIVE(1),
    UNACTIVE(2);

    private int userState;
    UserState(int userState){
        this.userState = userState;
    }

    public int getUserState() {
        return userState;
    }

    public void setUserState(int userState) {
        this.userState = userState;
    }
}
