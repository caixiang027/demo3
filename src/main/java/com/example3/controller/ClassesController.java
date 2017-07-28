package com.example3.controller;

import com.example3.domain.Classes;
import com.example3.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by mlamp on 2017/7/20.
 */
@Controller
public class ClassesController {

    @Autowired
    private ClassesService classesService;

    /**
     * 获取所有课程信息
     * @return
     */
    @PostMapping(value = "/class")
    @ResponseBody
    public List<Classes> selectAll(){
        return classesService.selectAll();
    }

}
