package com.jm.marketplace.controller;

import com.jm.marketplace.service.advertisement.AdvertisementService;
import com.jm.marketplace.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/")
public class MainController {

    private final AdvertisementService advertisementService;

    @Autowired
    public MainController(AdvertisementService advertisementService, UserService userService) {
        this.advertisementService = advertisementService;
    }

    @GetMapping
    public String showMainPage(Model model,
                               @RequestParam(value = "page", required = false, defaultValue = "0") Integer page) {
        model.addAttribute("allGoods", advertisementService.findAll(page));
        return "index";
    }


}
