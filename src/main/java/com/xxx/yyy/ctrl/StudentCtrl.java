package com.xxx.yyy.ctrl;

import com.xxx.yyy.entry.bo.StudentBO;
import com.xxx.yyy.entry.vo.ResponseEntry;
import com.xxx.yyy.entry.vo.StudentVO;
import com.xxx.yyy.service.intf.IStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentCtrl {

    @Autowired
    private IStudent studentService;

    @RequestMapping(value= "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntry add(@RequestBody StudentVO student) {
        int ei = studentService.addStudent(student);
        ResponseEntry responseEntry = new ResponseEntry();
        responseEntry.setCode(200);
        responseEntry.setMessage("success");
        responseEntry.setContent(ei);
        return responseEntry;
    }

    @RequestMapping(value = "/del/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntry del(@PathVariable("id") int id) {
        int ei = studentService.delStudent(id);
        ResponseEntry responseEntry = new ResponseEntry();
        responseEntry.setCode(200);
        responseEntry.setMessage("success");
        responseEntry.setContent(ei);
        return responseEntry;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntry update(@RequestBody StudentVO student) {
        int ei = studentService.updateStudent(student);
        ResponseEntry responseEntry = new ResponseEntry();
        responseEntry.setCode(200);
        responseEntry.setMessage("success");
        responseEntry.setContent(ei);
        return responseEntry;
    }

    @RequestMapping(value = "/query/all", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntry queryAll() {
        List<StudentBO> all = studentService.getAll();
        ResponseEntry responseEntry = new ResponseEntry();
        responseEntry.setCode(200);
        responseEntry.setMessage("success");
        responseEntry.setContent(all);
        return responseEntry;
    }

}
