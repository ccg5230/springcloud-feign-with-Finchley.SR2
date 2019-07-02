package zuul.server.config;

import com.netflix.zuul.FilterFileManager;
import com.netflix.zuul.FilterLoader;
import com.netflix.zuul.groovy.GroovyCompiler;
import com.netflix.zuul.groovy.GroovyFileFilter;
import com.netflix.zuul.monitoring.MonitoringHelper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Bean;
import zuul.server.filter.FirstPreFilter;
import zuul.server.filter.PostFilter;
import zuul.server.filter.SecondPreFilter;
import zuul.server.filter.ThirdPreFilter;

@Configuration
public class BasicConfiguration {

        @Bean //注入spring bean容器
    public FirstPreFilter firstPreFilter(){
    	return new FirstPreFilter();
    }

    @Bean
    public SecondPreFilter secondPreFilter(){
        return new SecondPreFilter();
    }

    @Bean
    public ThirdPreFilter thirdPreFilter(){
        return new ThirdPreFilter();
    }

    @Bean
    public PostFilter postFilter(){
        return new PostFilter();
    }

    /**
     * Groovy加载方法配置，20秒自动刷新
     */
    @Component
    public static class GroovyRunner implements CommandLineRunner {
        @Override
        public void run(String... args) throws Exception {
            MonitoringHelper.initMocks();
            FilterLoader.getInstance().setCompiler(new GroovyCompiler());
            try {
                FilterFileManager.setFilenameFilter(new GroovyFileFilter());
                FilterFileManager.init(20,
                        "E:\\IDEAWorkspace\\springcloudfeign\\zuul-server\\src\\main\\java\\zuul\\server\\groovy");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
