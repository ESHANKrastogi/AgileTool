package com.opensource.jiangbiao.agileTool.service;

import com.opensource.jiangbiao.agileTool.dao.UserDao;
import com.opensource.jiangbiao.agileTool.entity.User;
import com.opensource.jiangbiao.agileTool.entity.vo.UserVO;
import com.opensource.jiangbiao.agileTool.enums.UserState;
import com.opensource.jiangbiao.agileTool.unified.ResponseBean;
import com.opensource.jiangbiao.agileTool.unified.ResponseCode;
import com.opensource.jiangbiao.agileTool.utility.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.Table;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiang Biao
 * @date 11/9/2017 9:10 PM
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userDao;

    @Override
    public ResponseBean<Boolean> verify(String account, String password, HttpSession session) {
        ResponseBean<Boolean> msg=new ResponseBean<>();
        User user = userDao.findUserByAccount(account);
        if(user!=null&&user.getPassword().equals(password)){
            msg.setData(true);
            msg.setStatus(ResponseCode.OK);
            SessionUtil.setSession(user,session);
            return msg;
        }
        msg.setData(false);
        msg.setStatus(ResponseCode.FAILED);
        return msg;
    }

    @Override
    public ResponseBean<Boolean> addUser(User user) {
        ResponseBean<Boolean> msg=new ResponseBean<>();
        if(userDao.findUserByAccount(user.getAccount())!=null){
            msg.setData(false);
            msg.setStatus(ResponseCode.ACCOUNT_EXIST);
        }else {
            user.setUserState(UserState.ACTIVE);
            userDao.save(user);
            msg.setData(true);
            msg.setStatus(ResponseCode.ADD_USER_SUCESS);
        }
        return msg;
    }

    @Override
    public ResponseBean<Boolean> deleteUser(Long id) {
        ResponseBean<Boolean> msg=new ResponseBean<>();
        userDao.delete(id);
        msg.setData(true);
        msg.setStatus(ResponseCode.OK);
        return msg;
    }


    @Override
    public ResponseBean<List<UserVO>> getAllUser() {
        ResponseBean<List<UserVO>> msg=new ResponseBean<>();
        List<User> users = userDao.findAll();
        List<UserVO> userVOS = new ArrayList<>();
        for(User user:users){
            UserVO userVO = new UserVO();
            userVO.copy(user);
            userVOS.add(userVO);
        }
        msg.setData(userVOS);
        msg.setStatus(ResponseCode.OK);
        return msg;
    }


}
