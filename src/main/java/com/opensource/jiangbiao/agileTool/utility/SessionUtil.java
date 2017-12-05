package com.opensource.jiangbiao.agileTool.utility;

import com.opensource.jiangbiao.agileTool.entity.User;
import com.opensource.jiangbiao.agileTool.utility.Security.EncrypAES;

import javax.servlet.http.HttpSession;

/**
 * @author Jiang Biao
 * @date 11/12/2017 9:35 PM
 */
public class SessionUtil {


    public static void setSession(User user, HttpSession session){
        session.setAttribute("user",user);
    }

}
