package com.java.controller;

import com.java.service.impl.HomeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@RestController
public class HomeController {
    @Autowired
    private HomeServiceImpl service;

    @RequestMapping("/home/toIndex")
    public ModelAndView jump() {
        Runtime r = Runtime.getRuntime();
        Properties props = System.getProperties();
        ModelAndView mv = new ModelAndView();
        Map<String, Integer> map = service.getHomes();
        String dbVersion = service.selectHomes();

        Map<String, String> serverInfo = new HashMap<String, String>();
        serverInfo.put("jvmName", props.getProperty("java.vm.name"));
        serverInfo.put("jreVersion", props.getProperty("java.version"));
        serverInfo.put("javaPath", props.getProperty("java.home"));
        serverInfo.put("jvmTotalMemory", String.valueOf(r.totalMemory()));
        serverInfo.put("jvmFreeMemory", String.valueOf(r.freeMemory()));
        serverInfo.put("optName", props.getProperty("os.name"));
        serverInfo.put("optFrameWork", props.getProperty("os.arch"));
        serverInfo.put("dbVersion", dbVersion);

        /*List<Archives> list = archivesService.queryListByTop();
        list.stream().forEach(item -> {
            if (item.getTitle().length() > 20) {
                item.setTitle(item.getTitle().substring(0, 20) + "...");
            }
        });*/

       /* mv.addObject("newest", list);*/
        mv.addObject("map", map);
        mv.addObject("serverInfo", serverInfo);
        mv.setViewName("admin/Home");
        return mv;
    }
}
