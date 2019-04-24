package ribbon.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.ZoneAvoidanceRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
@AvoidScan
public class TestConfiguration {
	
	@Autowired
    IClientConfig config;

	@Bean
	//ribbon负载均衡策略
	public IRule ribbonRule(IClientConfig config) {
		//return new RandomRule(); //随机选择server
//		return new BestAvailableRule();
		return new ZoneAvoidanceRule();
	}
}