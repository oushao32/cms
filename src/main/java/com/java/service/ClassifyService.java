package com.java.service;

import com.java.pojo.Classify;
import org.apache.ibatis.annotations.Param;
import java.util.List;


public interface ClassifyService {
    List<Classify> getClassifys();
    int addClassify(@Param("classify") Classify classify);
    int delClassify(@Param("id") int id);
    int editClassify(@Param("classify") Classify classify);
}
