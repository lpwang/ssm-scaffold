package com.xxx.yyy.service;

import com.xxx.yyy.dao.entry.StudentEntry;
import com.xxx.yyy.dao.mapper.Students;
import com.xxx.yyy.entry.DemoEntry;
import com.xxx.yyy.service.intf.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoService implements IDemoService {

    @Autowired
    private Students students;

    public DemoEntry getDemoEntry() {
        StudentEntry studentEntry = students.getAllStudents().get(0);

        DemoEntry demoEntry = new DemoEntry();
        demoEntry.setId(studentEntry.getId());
        demoEntry.setContext(studentEntry.getName());
        return demoEntry;
    }

}
