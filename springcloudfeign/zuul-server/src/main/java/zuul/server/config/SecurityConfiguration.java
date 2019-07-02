package zuul.server.config;

//import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
//@EnableOAuth2Sso //OAuth2.0+JWT 授权认证
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//				.csrf().disable()// 关闭csrf验证
//				.authorizeRequests()// 对请求进行认证
////				.antMatchers("/login", "/auth/**")
//                .antMatchers().permitAll()// 所有xxx的请求 都放行
//				.anyRequest().authenticated()// 所有请求需要身份认证
//				;
//	}

	@Override
	//放行所有端点不作认证鉴权
	protected void configure(HttpSecurity http) throws Exception {
		http
				.requestMatcher(EndpointRequest.toAnyEndpoint())
				.authorizeRequests()
				.anyRequest()
				.permitAll();//许可所有请求
	}
}