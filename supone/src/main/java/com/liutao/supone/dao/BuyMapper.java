package com.liutao.supone.dao;

import com.liutao.supone.entity.Buy;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BuyMapper {
    List<Buy> selectBuyPersonId(Map<String, Object> paramMap);

    void insertBuy(Buy buy);
}
