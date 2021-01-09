package com.liutao.supone.controller;

import com.liutao.supone.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * .
 * Created by liutao20 on 2020/8/11
 */
@Controller
public class MainController {

    @Autowired
    private MainService mainService;

    @GetMapping
    public String index(Model model) throws Exception {
        mainService.getIndexModel(model);
        return "index";
    }

}
