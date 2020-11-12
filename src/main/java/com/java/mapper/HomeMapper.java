package com.java.mapper;

import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface HomeMapper {
    Map<String, Integer> getHomes();
    String selectHomes();
}
