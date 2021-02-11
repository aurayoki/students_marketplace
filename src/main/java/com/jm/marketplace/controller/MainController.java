package com.jm.marketplace.controller;

import com.jm.marketplace.service.advertisement.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class MainController {

    private final AdvertisementService advertisementService;

    @Autowired
    public MainController(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }

    @GetMapping
    public String showMainPage(Model model) {
        model.addAttribute("allGoods", advertisementService.findAll());
        return "index";
    }
}
