package feign.service;

import feign.service.impl.FeignClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Feign使用Hystrix, Feign的fallback测试类
 * 使用@FeignClient的fallback属性指定回退类
 */
@FeignClient(name = "feign-server",//name value互相设置了别名，用哪个都一样
        configuration = UserFeignService.FormSupportConfig.class,
        fallback = FeignClientFallback.class)//设置feign的Hystrix降级回退类
public interface IUserFeignClient {
	
	@RequestMapping(value = "/user/getUser",method = RequestMethod.GET)
    public String getUser(@RequestParam("username") String username);
    
}
