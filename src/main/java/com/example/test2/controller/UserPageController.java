package com.example.test2.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class UserPageController {

    @GetMapping("/")
    public String startPage(Model model) {
        log.info("Open start page");
        model.addAttribute("helloMsg", "Hello I'm the text from Java");
        return "index";
    }
}
