package com.opensource.jiangbiao.agileTool.controller;

import com.opensource.jiangbiao.agileTool.entity.Project;
import com.opensource.jiangbiao.agileTool.entity.vo.ProjectVO;
import com.opensource.jiangbiao.agileTool.entity.vo.UserVO;
import com.opensource.jiangbiao.agileTool.service.ProjectService;
import com.opensource.jiangbiao.agileTool.unified.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiang Biao
 * @date 11/12/2017 2:03 PM
 */
@RestController
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @PostMapping("/api/addProject")
    public ResponseEntity addProject(String name, String description, String startTime, String endTime,
                                     @RequestParam(value = "member[]") long[] member, HttpSession session){
        ResponseBean<Boolean> msg = projectService.addProject(name, description,  startTime, endTime, member,  session);
        return new ResponseEntity(msg,msg.getHttpStatus());
    }


    @PostMapping("/api/deleteProject")
    public ResponseEntity deleteProject(Long id){
        ResponseBean<Boolean> msg=projectService.deleteProject(id);
        return new ResponseEntity(msg,msg.getHttpStatus());
    }

    @GetMapping("/api/getAllProject")
    public ResponseEntity getAllProject(HttpSession session){
        ResponseBean<List<ProjectVO>> msg = projectService.getAllProject(session);
        return new ResponseEntity(msg,msg.getHttpStatus());
    }

    @GetMapping("/api/getProjectMember")
    public ResponseEntity getProjectMember(Long id){
        ResponseBean<List<UserVO>> msg= projectService.getProjectMember(id);
        return new ResponseEntity(msg,msg.getHttpStatus());
    }


}
