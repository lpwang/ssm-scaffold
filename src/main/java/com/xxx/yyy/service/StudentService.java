package com.xxx.yyy.service;

import com.xxx.yyy.dao.StudentDao;
import com.xxx.yyy.entry.bo.StudentBO;
import com.xxx.yyy.entry.vo.StudentVO;
import com.xxx.yyy.service.intf.IStudent;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService implements IStudent, InitializingBean {

    /**
     * 方法在beanPostProcessor的before和after之间被执行，在bean被初始化之后。
     * @throws Exception
     */
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet is called in => " + "StudentService");
    }

    @Autowired
    private StudentDao studentDao;

    @Transactional(isolation = Isolation.REPEATABLE_READ, transactionManager = "txManager", rollbackFor = Exception.class)
    public int addStudent(StudentVO student) {
        StudentBO studentBO = new StudentBO();
        studentBO.setAge(student.getAge());
        studentBO.setName(student.getName());
        return studentDao.addStudent(studentBO);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ, transactionManager = "txManager", rollbackFor = Exception.class)
    public int delStudent(int id) {
        return studentDao.deleteStudent(id);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ, transactionManager = "txManager", rollbackFor = Exception.class)
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
