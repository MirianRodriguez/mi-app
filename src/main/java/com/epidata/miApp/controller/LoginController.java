package com.epidata.miApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LoginController {
    @GetMapping("/login")
    public ModelAndView showLoginForm(Model model, 
        @RequestParam(name = "error", required = false) String error,
        @RequestParam(name="logout", required = false) String logout){
        model.addAttribute("error", error);
        model.addAttribute("logout", logout);
        return new ModelAndView("login");
    }

    @GetMapping({"/loginSuccess", "/"})
    public RedirectView loginCheck(){
        return new RedirectView("/contact/list");
    }
}

