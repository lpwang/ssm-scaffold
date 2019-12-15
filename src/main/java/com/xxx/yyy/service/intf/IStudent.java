package com.xxx.yyy.service.intf;

import com.xxx.yyy.entry.bo.StudentBO;
import com.xxx.yyy.entry.vo.StudentVO;

import java.util.List;

public interface IStudent {
    int addStudent(StudentVO student);

    int delStudent(int id);

    int updateStudent(StudentVO student);

    List<StudentBO> getAll();
}
