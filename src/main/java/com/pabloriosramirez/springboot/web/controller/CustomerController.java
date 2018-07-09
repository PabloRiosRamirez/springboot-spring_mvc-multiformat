/**
 * @author Pablo Ríos Ramírez
 * @Created 28-06-2018 2:43:46
 * @web http://www.pabloriosramirez.com
 *
 */

package com.pabloriosramirez.springboot.web.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.pabloriosramirez.springboot.web.service.ICustomerService;

@Controller
public class CustomerController {

    @Autowired
    private ICustomerService cs;

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public String customer(Model model) {
        model.addAttribute("customerList", cs.findAll());
        return "customer";
    }

}
