package com.opensource.jiangbiao.agileTool.controller;

import com.opensource.jiangbiao.agileTool.service.UserService;
import com.opensource.jiangbiao.agileTool.unified.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author Jiang Biao
 * @date 11/12/2017 2:14 PM
 */

@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping("/verify")
    public ResponseEntity verify(@RequestParam("name") String name, @RequestParam("password") String password, HttpSession session){
        ResponseBean<Boolean> msg = userService.verify(name,password,session);
        return new ResponseEntity(msg,msg.getHttpStatus());
    }



}
