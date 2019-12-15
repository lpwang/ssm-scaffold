package com.xxx.yyy.dao;

import com.xxx.yyy.entry.bo.StudentBO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface StudentDao {

    @Select("select * from students")
    List<StudentBO> getAllStudents();

    @Insert("insert into students (name,age) values (#{student.name},#{student.age})")
    int addStudent(StudentBO student);

    @Update("update students set name=#{student.name},age=#{student.age} where id=#{student.id}")
    int updateStudent(StudentBO student);

    @Delete("delete from students where id=#{param1}")
    int deleteStudent(int id);

}
