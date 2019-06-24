package zuul.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fwd")
public class FwdController {

    @GetMapping("/local")
    public String mult(Integer a, Integer b){
        return "本地跳转：" + (a * b);
    }
}