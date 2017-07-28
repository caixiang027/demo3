package com.example3.service;

import com.example3.domain.Classes;
import com.example3.mapper.ClassesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClassesService {
    @Autowired
    private ClassesMapper classesMapper;

    public List<Classes> selectAll(){

        return classesMapper.selectAll();
    }
}
