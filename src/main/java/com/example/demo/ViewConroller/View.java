package com.example.demo.ViewConroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class View {
    @RequestMapping("view")
    public String solve(){
        return "view.html";
    }

}
