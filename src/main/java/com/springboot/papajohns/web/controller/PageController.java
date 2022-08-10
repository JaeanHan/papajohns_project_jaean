package com.springboot.papajohns.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping({"/", "index"})
    public String index() {
        return "index";
    }

    @GetMapping("join")
    public String join() {return "join";}

    @GetMapping("page")
    public String page() {
        return "page";
    }
}
