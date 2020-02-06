package com.ygr.cts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yagnaguru.r
 */

@Controller
public class IndexController {
    @RequestMapping("/")
    public String getIndexPage(){
        return "index";
    }
}
