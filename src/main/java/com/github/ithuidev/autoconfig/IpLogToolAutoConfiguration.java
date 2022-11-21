package com.github.ithuidev.autoconfig;

import com.github.ithuidev.config.SpringMvcConfig;
import com.github.ithuidev.properties.IpLogProperties;
import com.github.ithuidev.service.IpLogService;
import com.github.ithuidev.service.impl.IpLogServiceImpl;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : ithuidev
 * @create : 2022/11/21
 */


@EnableScheduling
@Import({IpLogProperties.class, SpringMvcConfig.class})
public class IpLogToolAutoConfiguration {

    @Bean
    public IpLogService ipLogService(){
        return new IpLogServiceImpl();
    }
}
