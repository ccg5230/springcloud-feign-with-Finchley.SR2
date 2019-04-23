package feign.service;

import feign.Logger;
import feign.form.spring.SpringFormEncoder;
import feign.model.User;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import feign.codec.Encoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "feign-file-server", configuration = UserFeignService.FormSupportConfig.class)//name value互相设置了别名，用哪个都一样
public interface UserFeignService {

    @RequestMapping(value = "/user/add", method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addUser(User user);

    @RequestMapping(value = "/user/update", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updateUser(@RequestBody User user);

    /**
     * 解决报错
     * feign.codec.EncodeException: class feign.model.User is not a type supported by this encoder.
     */
    class FormSupportConfig {
        @Autowired
        private ObjectFactory<HttpMessageConverters> messageConverters;
        // new一个form编码器，实现支持form表单提交
        @Bean
        public Encoder feignFormEncoder() {
            return new SpringFormEncoder(new SpringEncoder(messageConverters));
        }
        // 开启Feign的日志
        @Bean
        public Logger.Level logger() {
            return Logger.Level.FULL;
        }
    }
}
