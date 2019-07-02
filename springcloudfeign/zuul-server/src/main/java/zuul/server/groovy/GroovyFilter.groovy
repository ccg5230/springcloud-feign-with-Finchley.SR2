package zuul.server.groovy

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.*;

import javax.servlet.http.HttpServletRequest

import com.netflix.zuul.ZuulFilter
import com.netflix.zuul.context.RequestContext
import com.netflix.zuul.exception.ZuulException

/**
 * Groovy是一种基于JVM（Java虚拟机）的敏捷开发语言，它结合了Python、Ruby和Smalltalk的许多强大的特性，
 * Groovy 代码能够与 Java 代码很好地结合，也能用于扩展现有代码。
 * 由于其运行在 JVM 上的特性，Groovy 可以使用其他 Java 语言编写的库。
 * 可以不用启动服务更新代码，效率很好没有用到字节码生成器
 */
class GroovyFilter extends ZuulFilter {

	@Override
	public String filterType() {
		return PRE_TYPE
	}
	
	@Override
	public int filterOrder() {
		return 10
	}
	
	@Override
	public boolean shouldFilter() {
		return true
	}

	@Override
	public Object run() throws ZuulException {
		HttpServletRequest request = RequestContext.currentContext.request as HttpServletRequest
		Iterator headerIt = request.getHeaderNames().iterator()
		while (headerIt.hasNext()) {
			String name = (String) headerIt.next()
			String value = request.getHeader(name)
			println("header: " + name + ":" + value)
		}
		println("This is Groovy Filter! Amazing, It can be modified dynamically!")
		return null
	}
}
