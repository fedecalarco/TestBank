/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Training.AAFLP.14
 */
@Controller
@RequestMapping(value="/HB")
public class BankController {
    
    @RequestMapping(value="/index")
    public ModelAndView registrar (Model m){
        return new ModelAndView("home");
    }
    
}