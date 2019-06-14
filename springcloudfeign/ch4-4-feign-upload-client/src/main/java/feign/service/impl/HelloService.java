package feign.service.impl;


import java.util.List;

import feign.service.IHelloService;
import feign.service.dataservice.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * 
 */
@Component
public class HelloService implements IHelloService {
	
    @Autowired
    private ProviderService dataService;

	@Override
	public List<String> getProviderData() {
		return dataService.getProviderData();
	}

}
