package com.opensource.jiangbiao.agileTool.service;

import com.opensource.jiangbiao.agileTool.entity.User;
import com.opensource.jiangbiao.agileTool.entity.vo.UserVO;
import com.opensource.jiangbiao.agileTool.unified.ResponseBean;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Jiang Biao
 * @date 11/9/2017 9:09 PM
 */
public interface UserService {

    public ResponseBean<Boolean> verify(String name, String password, HttpSession session);
    public ResponseBean<Boolean> addUser(User user);
    public ResponseBean<Boolean> deleteUser(Long id);
    public ResponseBean<List<UserVO>> getAllUser();


}
