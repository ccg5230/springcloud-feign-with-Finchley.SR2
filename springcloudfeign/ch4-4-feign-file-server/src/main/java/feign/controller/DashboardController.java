package feign.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {
   
    @GetMapping("/getDashboard")
    public List<String> getProviderData(){
    	List<String> provider = new ArrayList<String>();
    	provider.add("hystrix dashboard");
        return provider;
    }
    
}
