package feign.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/ribbon")
public class RibbonTestController {

    @GetMapping("/add")
    public String add(Integer a, Integer b, HttpServletRequest request){
        return " From Port: "+ request.getServerPort() + ", Result: " + (a + b);
    }
}

