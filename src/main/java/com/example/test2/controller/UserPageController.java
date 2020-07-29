package com.example.test2.controller;

import com.example.test2.dto.Test;
import com.example.test2.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class UserPageController {

    private final UserService userService;
    public static final String LOCALE = "ru";

    @GetMapping("/")
    public String startPage(Model model) {
        log.info("Open start page");
        model.addAttribute("helloMsg", "Hello I'm the text from Java");
        model.addAttribute("users", userService.getUsers());

        Test test =  new Test("Myname", "Myvalue");
        model.addAttribute("test", test);
        model.addAttribute("localePrefix", LOCALE);
        model.addAttribute("page", 1);

        List<Test> list = new ArrayList<>();
        list.add(new Test ("Name1", "Value1"));
        list.add(new Test ("Name2", "Value2"));
        list.add(new Test ("Name3", "Value3"));
        list.add(new Test ("Name4", "Value4"));
        model.addAttribute("testList", list);

        model.addAttribute("role", "admin");
        model.addAttribute("isManager", "false");
        model.addAttribute("expiredSession", "false");


        return "index";
    }
}
