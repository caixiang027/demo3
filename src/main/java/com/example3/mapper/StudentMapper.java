package com.example3.mapper;

import com.example3.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mlamp on 2017/7/20.
 */
@Repository
public interface StudentMapper {

    Integer deleteById(Integer id);

    List<Student> selectAll();

    List<Student> selectAllDetail();

    Integer updateStudent(Student student);

    Integer insert(Student student);

}
