package com.java.mapper;

import com.java.pojo.Classify;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassifyMapper {
    List<Classify> getClassifys();
    int addClassify(@Param("classify") Classify classify);
    int delClassify(@Param("id") int id);
    int editClassify(@Param("classify")Classify classify);
}
