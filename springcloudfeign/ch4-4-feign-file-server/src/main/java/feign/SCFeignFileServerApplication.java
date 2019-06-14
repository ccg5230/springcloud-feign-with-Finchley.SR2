package feign;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix //启用断路器模式
@EnableFeignClients
public class SCFeignFileServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SCFeignFileServerApplication.class, args);
    }
}