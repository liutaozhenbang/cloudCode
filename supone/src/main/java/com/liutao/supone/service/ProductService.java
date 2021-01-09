package com.liutao.supone.service;

import com.liutao.supone.dao.ProductMapper;
import com.liutao.supone.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * .
 * Created by liutao20 on 2020/8/11
 */
@Service
public class ProductService {

    @Autowired
    private ProductMapper productMapper;

    public List<Product> selectProductList() {
        List<Product> productList = productMapper.selectProductList();
        for (int i = 0; i < productList.size(); i++) {
            productList.get(i).setName(productList.get(i).getName() + "   " + productList.get(i).getPrice());
        }
        return productList;
    }

    public Product selectProductById(Integer productId) {
        return productMapper.selectProductById(productId);
    }
}
