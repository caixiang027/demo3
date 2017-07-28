package com.example3.service;

import com.example3.domain.Student;
import com.example3.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mlamp on 2017/7/20.
 */
@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public List<Student> selectAll(){
        return studentMapper.selectAll();
    }

    public List<Student> selectAllDetail(){
        return studentMapper.selectAllDetail();
    }

    public Integer updateStudent(Student student){

        return studentMapper.updateStudent(student);
    }

    public Integer insert(Student student){

        return studentMapper.insert(student);
    }

    public Integer delete(Integer id){

        return studentMapper.deleteById(id);
    }

}
