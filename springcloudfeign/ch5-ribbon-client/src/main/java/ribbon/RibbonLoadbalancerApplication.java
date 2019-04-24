package ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;
import ribbon.config.AvoidScan;
import ribbon.config.TestConfiguration;

@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name = "feign-server", configuration = TestConfiguration.class)
//@RibbonClients(value = { //对多个源服务指定策略
//		@RibbonClient(name = "client-a", configuration = TestConfiguration.class),
//		@RibbonClient(name = "client-b", configuration = TestConfiguration.class)
//})
//通过excludeFilters过滤出不用加入spring容器的类,从而设置@Configuration修饰类不应用于全局配置
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {AvoidScan.class})})
public class RibbonLoadbalancerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RibbonLoadbalancerApplication.class, args);
    }
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
