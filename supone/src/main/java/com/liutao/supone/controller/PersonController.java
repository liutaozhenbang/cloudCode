package com.liutao.supone.controller;

import com.liutao.supone.entity.Buy;
import com.liutao.supone.service.BuyService;
import com.liutao.supone.service.MainService;
import com.liutao.supone.service.PersonService;
import com.liutao.supone.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * .
 * Created by liutao20 on 2020/8/11
 */
@Controller
@RequestMapping("person")
public class PersonController {

    @Autowired
    private BuyService buyService;

    @Autowired
    private PersonService personService;

    @Autowired
    private ProductService productService;

    @Autowired
    private MainService mainService;

    @GetMapping("list")
    public String listProdect(@RequestParam("personId") Integer personId, @RequestParam("startDate") String startDate,
                              @RequestParam("endDate") String endDate, Model model) throws Exception {
        mainService.getIndexModel(model, personId, startDate, endDate);
        return "index";
    }

    @GetMapping("delete")
    public String delete(int id) {
        System.out.println("删除" + id);
        return "index";
    }

    @PostMapping("add")
    public String add(@ModelAttribute Buy buy, Model model) throws Exception {
        buyService.addBuy(buy);
        mainService.getIndexModel(model, buy.getPersonId(), buy.getStartDate(), buy.getEndDate());
        return "index";
    }

}
