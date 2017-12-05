package com.opensource.jiangbiao.agileTool.controller;

import com.opensource.jiangbiao.agileTool.entity.Issue;
import com.opensource.jiangbiao.agileTool.entity.vo.IssueVO;
import com.opensource.jiangbiao.agileTool.service.ProjectService;
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
public class IssueController {

    @Autowired
    ProjectService projectService;


    @PostMapping("/api/addIssue")
    public ResponseEntity addIssue(Long projectId, String title, String description, Long assigneesId, String index, Long effort, String startTime, String endTime){
        ResponseBean<Boolean> msg = projectService.addIssue(projectId,title,description,assigneesId,index,effort,startTime,endTime);
        return new ResponseEntity(msg,msg.getHttpStatus());
    }
    @PostMapping("/api/deleteIssue")
    public ResponseEntity deleteIssue(Long projectId,Long id) {
        ResponseBean<Boolean> msg=projectService.deleteIssue(projectId,id);
        return new ResponseEntity(msg,msg.getHttpStatus());
    }

    @GetMapping("/api/getAllIssue")
    public ResponseEntity getAllIssue(Long projectId){
        ResponseBean<List<IssueVO>> msg = projectService.getAllIssue(projectId);
        return new ResponseEntity(msg,msg.getHttpStatus());

    }

}
