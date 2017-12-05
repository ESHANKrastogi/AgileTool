package com.opensource.jiangbiao.agileTool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Jiang Biao
 * @date 11/12/2017 11:06 PM
 */
//@Configuration
public class WebSecurityConfig extends WebMvcConfigurerAdapter {


    @Bean
    public SessionInterceptor getSessionInterceptor() {
        return new SessionInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /*调用我们创建的SessionInterceptor。
        * addPathPatterns("/api/**)的意思是这个链接下的都要进入到SessionInterceptor里面去执行
        * excludePathPatterns("/login")的意思是login的url可以不用进入到SessionInterceptor中，直接
        * 放过执行。
        *
        * 注意：如果像注释那样写是不可以的。这样等于是创建了多个Interceptor。而不是只有一个Interceptor
        * 所以这里有个大坑，搞了很久才发现问题。
        *
        * */
        SessionInterceptor sessionInterceptor=new SessionInterceptor();
        registry.addInterceptor(sessionInterceptor).addPathPatterns("/api/**")
                .addPathPatterns("/")
                .excludePathPatterns("/login","/verify");
//        registry.addInterceptor(sessionInterceptor).excludePathPatterns("/login");
//        registry.addInterceptor(sessionInterceptor).excludePathPatterns("/verify");
        super.addInterceptors(registry);
    }
}
