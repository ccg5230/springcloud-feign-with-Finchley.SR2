package feign.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ZuulController {

    @GetMapping("/add")
    public Integer add(Integer a, Integer b){
        return a + b;
    }
}
