package com.liutao.supone.service;

import com.liutao.supone.dao.BuyMapper;
import com.liutao.supone.entity.Buy;
import com.liutao.supone.entity.Product;
import com.liutao.supone.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * .
 * Created by liutao20 on 2020/8/11
 */
@Service
public class BuyService {

    @Autowired
    private BuyMapper buyMapper;

    @Autowired
    private ProductService productService;

    public Map<String, Object> selectBuyPersonId(Integer personId, String startDate, String endDate) throws Exception {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("personId", personId);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        paramMap.put("startDate", sdf.parse(DateUtil.emptyDefaultDay(startDate)));
        paramMap.put("endDate", sdf.parse(DateUtil.emptyDefaultDay(endDate)));
        List<Buy> buylist = buyMapper.selectBuyPersonId(paramMap);
        Double totalMenoy = 0.0;
        for (int i = 0; i < buylist.size(); i++) {
            totalMenoy += buylist.get(i).getBuyMoney();
        }
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("buyList", buylist);
        resultMap.put("totalMenoy", "总价： " + totalMenoy);
        return resultMap;
    }

    public void addBuy(Buy buy) {
        if (buy.getBuyNum() == null || buy.getBuyNum() == 0 || buy.getProductId() == null || buy.getProductId() == 0) {
            return;
        }
        Product product = productService.selectProductById(buy.getProductId());
        buy.setProductName(product.getName());
        buy.setBuyPrice(product.getPrice());
        buy.setBuyMoney(product.getPrice() * buy.getBuyNum());
        buy.setCreateTime(new Date());
        buyMapper.insertBuy(buy);
    }
}
