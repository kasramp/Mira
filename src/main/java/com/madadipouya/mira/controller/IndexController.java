package com.madadipouya.mira.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String getHome(Model model) {
        //model.addAttribute("test", "test value");
        return "index";
    }
}
