package com.josimas.projectone.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String home()
    {
        return "home";
    }

    @RequestMapping("/blog")
    public String blog()
    {
        return "blog";
    }

    @RequestMapping("/contact")
    public String contact()
    {
        return "contact";
    }

}
