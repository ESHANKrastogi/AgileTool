package com.opensource.jiangbiao.agileTool.unified;

import java.util.HashMap;

/**
 * @author Jiang Biao
 * @date 11/12/2017 2:18 PM
 */
public class CodeMapMessage {

    public static final HashMap<Integer,String> map=new HashMap<Integer, String>();
    static {
        map.put(0,"Your operate error");
        map.put(1,"Your operate success");
        map.put(11,"This account is exist");
        map.put(12,"Add user success");
        map.put(13,"This project is exits,choose another name");
        map.put(200,"Your operate success");
        map.put(400,"Your operate faild");


    }

}
