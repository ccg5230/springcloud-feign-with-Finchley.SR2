package hystrix.dashboard.service;
import hystrix.dashboard.config.HystrixThreadLocal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class ThreadContextService implements IThreadContextService{
	private static final Logger log = LoggerFactory.getLogger(ThreadContextService.class);

	@Autowired
	private RestTemplate restTemplate;
	
   @HystrixCommand //Hystrix通过命令模式，将每个类型的业务请求封装成对应的命令请求
	public String getUser(Integer id) {
		log.info("ThreadContextService, Current thread : " + Thread.currentThread().getId());
		//适用线程隔离将导致Hystrix创建新线程处理后台服务请求，HystrixThreadLocal.threadLocal.get获取结果为null
		log.info("ThreadContextService, ThreadContext object : " + HystrixThreadLocal.threadLocal.get());
		log.info("ThreadContextService, RequestContextHolder : " + RequestContextHolder.currentRequestAttributes().
				getAttribute("userId", RequestAttributes.SCOPE_REQUEST).toString());
		String json = restTemplate.getForObject("http://feign-server/getUser/{1}", String.class, id);
		return json;
	}
   
   
	
}
