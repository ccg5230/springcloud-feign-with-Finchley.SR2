package feign.service.impl;

import feign.service.IUserFeignClient;
import org.springframework.stereotype.Component;

@Component
public class FeignClientFallback implements IUserFeignClient {
	/**
	  * 出错则调用该方法返回友好错误:服务提供方出错或者执行了fellback都会执行执行该方法
	  * @param username
	  * @return
	  */
	public String getUser(String username){
		return "The user does not exist in this system, please confirm username, or check the system for errors!";
	}
}
