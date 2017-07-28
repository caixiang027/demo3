package com.example3.mapper;

import com.example3.domain.Classes;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mlamp on 2017/7/20.
 */
@Repository
public interface ClassesMapper {

    List<Classes> selectAll();
}
