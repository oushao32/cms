package com.java.controller;

import com.java.pojo.Classify;
import com.java.service.impl.ClassifyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClassifyController {
    @Autowired
    private ClassifyServiceImpl service;

    @RequestMapping(value = {"/index/toClassify","/admin/toClassify"})
    public String getClassifys(Model model) {
        List<Classify> classifys = service.getClassifys();
        model.addAttribute("list", classifys);
        return "admin/classify/list";
    }
    /*@PostMapping("/admin/addClassify")
    public int addClassify(Classify classify) {
        return service.addClassify(classify);
    }
    @RequestMapping("admin/delClassify")
    public int delClassify(int id) {
        return service.delClassify(id);
    }
    @PostMapping("/admin/editClassify")
    public int editClassify(Classify classify) {
        return service.editClassify(classify);
    }*/
}
