package com.github.ithuidev.config;

import com.github.ithuidev.Interceptor.IpLogInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : ithuidev
 * @create : 2022/11/21
 */
@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {

    @Bean
    public IpLogInterceptor ipLogInterceptor(){
        return new IpLogInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(ipLogInterceptor()).addPathPatterns("/**");

    }
}
