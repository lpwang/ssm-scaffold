package com.xxx.yyy.ctrl;

import com.xxx.yyy.entry.DemoEntry;
import com.xxx.yyy.service.intf.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoCtrl {

    @Autowired
    private IDemoService demoService;

    @RequestMapping("/demo/string/method")
    @ResponseBody
    public String DemoStringMethod() {
        return "hello this is demo string";
    }

    @RequestMapping("/demo/entry/method")
    @ResponseBody
    public DemoEntry DemoEntryMethod() {
        DemoEntry demoEntry = demoService.getDemoEntry();
        return demoEntry;
    }

}
