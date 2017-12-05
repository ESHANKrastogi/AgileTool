package com.opensource.jiangbiao.agileTool.controller;

import com.opensource.jiangbiao.agileTool.entity.User;
import com.opensource.jiangbiao.agileTool.entity.vo.UserVO;
import com.opensource.jiangbiao.agileTool.service.UserService;
import com.opensource.jiangbiao.agileTool.unified.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Jiang Biao
 * @date 11/12/2017 2:03 PM
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/api/addUser")
    public ResponseEntity addUser(User user){
        ResponseBean<Boolean> msg=userService.addUser(user);
        return new ResponseEntity(msg,msg.getHttpStatus());
    }

    @PostMapping("/api/deleteUser")
    public ResponseEntity deleteUser(Long id){
        ResponseBean<Boolean> msg=userService.deleteUser(id);
        return new ResponseEntity(msg,msg.getHttpStatus());
    }

    @GetMapping("/api/getAllUser")
    public ResponseEntity getAllUser(){
        ResponseBean<List<UserVO>> msg=userService.getAllUser();
        return new ResponseEntity(msg,msg.getHttpStatus());
    }

}
