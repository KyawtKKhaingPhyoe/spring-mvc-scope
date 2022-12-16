package com.example.springmvcscope.controller;

import com.example.springmvcscope.bean.ApplicationScopeBean;
import com.example.springmvcscope.bean.RequestScopeBean;
import com.example.springmvcscope.bean.SessionScopeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

@Controller
public class IndexController {

    @Autowired
    private ApplicationScopeBean applicationScopeBean;

    @Autowired
    private SessionScopeBean sessionScopeBean;

    @Autowired
    private RequestScopeBean requestScopeBean;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @RequestMapping(value = "/",method = {RequestMethod.GET,RequestMethod.POST})
    public String index(Model model){
        model.addAttribute("webApplicationContext",webApplicationContext.getServletContext());
        model.addAttribute("requestValue",requestScopeBean.getValue());
        model.addAttribute("sessionValue",sessionScopeBean.getValue());
        model.addAttribute("applicationValue",applicationScopeBean.getValue());

        return "index";
    }

    @PostMapping("/request")
    public String saveRequestValue(@RequestParam("request") int value){
        requestScopeBean.setValue(value);
        System.out.println("RequestValue :: ======"+value);
        return "forward:/";
    }

    @PostMapping("/session")
    public String saveSessionValue(@RequestParam("session") int value){
        System.out.println("SessionValue :: ======="+value);
        sessionScopeBean.setValue(value);
        return "redirect:/";
    }

    @PostMapping("/application")
    public String saveApplicationValue(@RequestParam("application") int value){
        System.out.println("ApplicationValue :: ========"+value);
        applicationScopeBean.setValue(value);
        return "redirect:/";
    }

}
