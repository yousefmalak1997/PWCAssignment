package com.pwc.complaintmanagementportal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthenticationController {

    @RequestMapping(value = {"/login"},method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = {"/register"},method = RequestMethod.GET)
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @RequestMapping(value = {"/home"},method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @RequestMapping(value = {"/index"},method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = {"/createComplaint"},method = RequestMethod.GET)
    public ModelAndView createComplaint() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("createComplaint");
        return modelAndView;
    }

    @RequestMapping(value = {"/viewComplaints"},method = RequestMethod.GET)
    public ModelAndView viewComplaints() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("viewComplaints");
        return modelAndView;
    }
}
