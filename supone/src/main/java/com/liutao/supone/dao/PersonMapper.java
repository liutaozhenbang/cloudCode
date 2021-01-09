package com.liutao.supone.dao;

import com.liutao.supone.entity.Person;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PersonMapper {

    List<Person> selectList();

}
