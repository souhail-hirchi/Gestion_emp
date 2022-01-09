package com.groupe10.GestionEmp.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/employe")
public class MainController {

    @GetMapping("")
    public String ShowHomePage(){
        return "index";
    }
}
