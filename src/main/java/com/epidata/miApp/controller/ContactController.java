package com.epidata.miApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.epidata.miApp.model.ContactModel;
import com.epidata.miApp.service.ContactService;

@Controller
@RequestMapping("contact")
public class ContactController {

    @Autowired
    @Qualifier("contactService")
    private ContactService contactService;

    @GetMapping("/list")
    public ModelAndView listContacts(){

        ModelAndView mav = new ModelAndView("contacts");
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        mav.addObject("username", user.getUsername());
        mav.addObject("contacts", contactService.getContacts());
        return mav;
    }

    @GetMapping("/form")
    @PreAuthorize("hasRole('USER_ROLE')")
    public ModelAndView form(@RequestParam Long id){
        ModelAndView mav = new ModelAndView("contactform");
        ContactModel contact = new ContactModel();
        if(id!=0){
            contact = contactService.getById(id);
        }
        mav.addObject("contact", contact);
        return mav;
    }

    @PostMapping("/save")
    public RedirectView saveContact(@ModelAttribute ContactModel contactModel){
        contactService.saveContact(contactModel);
        return new RedirectView("/contact/list");
    }

    @GetMapping("/delete/{id}")
    public RedirectView deleteContact(@PathVariable Long id){
        contactService.deleteContact(id);
        return new RedirectView("/contact/list");
    }

}
