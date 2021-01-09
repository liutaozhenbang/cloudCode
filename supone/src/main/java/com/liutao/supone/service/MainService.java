package com.liutao.supone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * .
 * Created by liutao20 on 2020/8/11
 */
@Service
public class MainService {

    @Autowired
    private BuyService buyService;

    @Autowired
    private PersonService personService;

    @Autowired
    private ProductService productService;

    public void getIndexModel(Model model) throws Exception {
        String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        this.getIndexModel(model, null, today, today);
    }

    public void getIndexModel(Model model, Integer personId, String startDate, String endDate) throws Exception {
        Map<String, Object> personMap = personService.selectPersonList(personId, startDate, endDate);
        model.addAttribute("personList", personMap.get("personList"));
        model.addAttribute("currentPerson", personMap.get("currentPerson"));
        Map<String, Object> buyMap = buyService.selectBuyPersonId(personId, startDate, endDate);
        model.addAttribute("buyList", buyMap.get("buyList"));
        model.addAttribute("totalMenoy", buyMap.get("totalMenoy"));
        model.addAttribute("productList", productService.selectProductList());
    }
}
