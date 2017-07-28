package com.example3.controller;

import com.example3.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

/**
 * Created by mlamp on 2017/7/20.
 */
@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    /**
     * 获取课程表所有信息
     * @return
     */
    @RequestMapping(value = "course" ,method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String,Object>> selectWithStudent(){

        return courseService.selectWithStudent();
    }

    /**
     * 课程信息表模糊查询
     * @param name：表示字段属性
     * @param value：表示字段的值
     * @return
     */
    @RequestMapping(value = "course/selectCourseLike/{name}/{value}" ,method = RequestMethod.POST)
    @ResponseBody
    public List<Map<String,Object>> selectCourseLike(@PathVariable String name,
                                                     @PathVariable String value){
        return courseService.selectCourseLike(name,value);
    }

}
