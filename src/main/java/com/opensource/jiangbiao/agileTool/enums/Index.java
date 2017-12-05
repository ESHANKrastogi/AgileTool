package com.opensource.jiangbiao.agileTool.enums;

/**
 * @author Jiang Biao
 * @date 11/9/2017 3:37 PM
 */
public enum  Index {

    INBOX(1),
    TO_DO(2),
    IN_PROGRESS(3),
    DONE(4);

    private int index;
    Index(int index){
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
