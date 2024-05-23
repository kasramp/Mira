package com.madadipouya.mira.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import static com.madadipouya.mira.util.UrlUtil.getBaseUrl;

@Controller
public class IndexController {

    @GetMapping("/")
    public String getHome(Model model, @RequestHeader(value = "User-Agent") String userAgent, HttpServletRequest request) {
        if (!StringUtils.contains(userAgent, "curl")) {
            return "index";
        }
        model.addAttribute("baseUrl", getBaseUrl(request));
        return "index_curl";
    }
}
