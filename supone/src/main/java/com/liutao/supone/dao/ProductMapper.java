package com.liutao.supone.dao;

import com.liutao.supone.entity.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    List<Product> selectProductList();

    Product selectProductById(Integer productId);
}
