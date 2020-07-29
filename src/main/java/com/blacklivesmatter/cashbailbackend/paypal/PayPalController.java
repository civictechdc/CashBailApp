package com.blacklivesmatter.cashbailbackend.paypal;

import com.blacklivesmatter.cashbailbackend.paypal.PayPalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PayPalController {

    @Autowired
    PayPalService service;

    @GetMapping("/donatePaypal")
    public String donatePaypal(){
        return "donatePaypal";
    }

}
