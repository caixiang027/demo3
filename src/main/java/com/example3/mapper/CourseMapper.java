package com.example3.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by mlamp on 2017/7/20.
 */
@Repository
public interface CourseMapper {

    List<Map<String,Object>> selectWithStudent();

    List<Map<String,Object>> selectCourseLike(String name, String value);

    Integer deleteByUid(Integer id);

}
