package com.xxx.yyy.service;

import com.xxx.yyy.dao.StudentDao;
import com.xxx.yyy.entry.bo.StudentBO;
import com.xxx.yyy.entry.vo.StudentVO;
import com.xxx.yyy.service.intf.IStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudent {

    @Autowired
    private StudentDao studentDao;

    public int addStudent(StudentVO student) {
        StudentBO studentBO = new StudentBO();
        studentBO.setAge(student.getAge());
        studentBO.setName(student.getName());
        return studentDao.addStudent(studentBO);
    }

    public int delStudent(int id) {
        return studentDao.deleteStudent(id);
    }

    public int updateStudent(StudentVO student) {
        StudentBO studentBO = new StudentBO();
        studentBO.setAge(student.getAge());
        studentBO.setName(student.getName());
        return studentDao.updateStudent(studentBO);
    }

    public List<StudentBO> getAll() {
        return studentDao.getAllStudents();
    }
}
