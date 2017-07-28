package com.example3.controller;

import com.example3.domain.Student;
import com.example3.service.CourseService;
import com.example3.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by mlamp on 2017/7/20.
 */
@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;

    /**
     * 获取所有学生信息
     * @return
     */
    @GetMapping(value = "/student")
    @ResponseBody
    public List<Student> selectAll(){

        return studentService.selectAll();
    }

    /**
     * 获取学生详细信息，有级联
     * @return
     */
    @GetMapping(value = "/getStudentDetail")
    @ResponseBody
    public List<Student> selectAllDetail(){

        return studentService.selectAllDetail();
    }

    /**
     * 学生信息的修改
     * @param student
     * @return
     */
    @PutMapping (value = "/updateStudent")
    @ResponseBody
    public Integer updateStudent(@RequestBody Student student){

        return studentService.updateStudent(student);
    }

    /**
     * 学生信息的增加
     * @param student
     * @return
     */
    @PostMapping (value = "/addStudent")
    @ResponseBody
    public Integer insert(@RequestBody Student student){

        return studentService.insert(student);
    }

    /**
     * 学生信息的删除，会有连带的课程的删除
     * @param id
     * @return
     */
    @PostMapping (value = "/deleteStudent/{id}")
    @ResponseBody
    @Transactional
    public Integer delete(@PathVariable Integer id){

        return courseService.deleteByUid(id)+studentService.delete(id);
    }

}
