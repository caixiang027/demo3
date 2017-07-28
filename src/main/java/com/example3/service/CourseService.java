package com.example3.service;

import com.example3.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class CourseService {
    @Autowired
    private CourseMapper courseMapper;

    public List<Map<String,Object>> selectWithStudent(){

        return courseMapper.selectWithStudent();
    }

    public List<Map<String,Object>> selectCourseLike(String name, String value){

        return courseMapper.selectCourseLike(name,value);
    }

    public Integer deleteByUid(Integer id){

        return courseMapper.deleteByUid(id);
    }

}
