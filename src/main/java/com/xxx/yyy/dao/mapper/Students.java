package com.xxx.yyy.dao.mapper;

import com.xxx.yyy.dao.entry.StudentEntry;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface Students {

    @Select("select * from students")
    List<StudentEntry> getAllStudents();

}
