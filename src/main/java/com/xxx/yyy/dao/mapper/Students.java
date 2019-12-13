package com.xxx.yyy.dao.mapper;

import com.xxx.yyy.dao.entry.StudentEntry;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface Students {

    @Select("select * from students")
    List<StudentEntry> getAllStudents();

    @Insert("insert into students (name,age) values (#{student.name},#{student.age})")
    int addStudent(StudentEntry student);

    @Update("update students set name=#{student.name},age=#{student.age} where id=#{student.id}")
    int updateStudent(StudentEntry student);

    @Delete("delete from students where id=#{param1}")
    int deleteStudent(int id);

}
