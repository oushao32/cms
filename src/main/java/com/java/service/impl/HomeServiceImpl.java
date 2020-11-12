package com.java.service.impl;

import com.java.mapper.HomeMapper;
import com.java.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class HomeServiceImpl implements HomeService {
    @Autowired
    private HomeMapper mapper;
    @Override
    public Map<String, Integer> getHomes() {
        return mapper.getHomes();
    }

    @Override
    public String selectHomes() {
        return mapper.selectHomes();
    }
}
