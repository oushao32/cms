package com.java.service.impl;

import com.java.mapper.ClassifyMapper;
import com.java.pojo.Classify;
import com.java.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassifyServiceImpl implements ClassifyService {
    @Autowired
    private ClassifyMapper mapper;
    @Override
    public List<Classify> getClassifys() {
        return mapper.getClassifys();
    }

    @Override
    public int addClassify(Classify classify) {
        return mapper.addClassify(classify);
    }

    @Override
    public int delClassify(int id) {
        return mapper.delClassify(id);
    }

    @Override
    public int editClassify(Classify classify) {
        return mapper.editClassify(classify);
    }
}
