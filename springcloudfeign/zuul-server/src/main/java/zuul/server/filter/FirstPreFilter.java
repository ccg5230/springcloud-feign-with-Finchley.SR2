package zuul.server.filter;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.*;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

/**
 * ZuulFilter：默认的filter可以通过配置去掉：zuul.<SimpleClassName>.<filterType>.disable=true
 */
public class FirstPreFilter extends ZuulFilter {
	
	@Override
	public String filterType() {
		return PRE_TYPE;
	}
	
	@Override
	/**
	 * 执行顺序：
	 * 1）首先执行pre类型的filter
	 * 2）执行route类型的filter（逻辑和pre的类似），默认了几个重要的route的filter，用以实现路由功能：
	 * 		默认的filter如下:RibbonRoutingFilter :10、SimpleHostRoutingFilter:100、SendForwardFilter:500
	 * 3）所有的route类型的filter执行完毕后，才开始执行post类型的filter
	 * 4）filterOrder数字越小（含负数），越先执行
	 * 5）filter报错后执行error类型的filiter
	 */
	public int filterOrder() {
		return 0;
	}

	@Override
	//设置该Filter是否执行
	public boolean shouldFilter() {
		return true;
	}

	@Override
	//Filter核心执行逻辑： 访问zuul路由时，该方法被调用
	public Object run() throws ZuulException {
		System.out.println("这是第一个自定义Zuul Filter！");
		return null;
	}
}
