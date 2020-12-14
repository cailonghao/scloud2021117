package com.unipush;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.unipush.push.UnipushService;
import com.unipush.push.UnipushServiceImpl;
import com.unipush.template.MessageTemplate;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.concurrent.TimeUnit;

@ConditionalOnWebApplication
@EnableConfigurationProperties(UnipushProperties.class)
@Configuration
public class UniappConfig {


    public static Cache<String, Object> TOKEN_CACHE = CacheBuilder.newBuilder()
            .initialCapacity(10) //设置缓存初始大小，应该合理设置，后期会扩容
            .maximumSize(100) //最大值
            .concurrencyLevel(5) //并发数
            .expireAfterWrite(4, TimeUnit.HOURS) //缓存过期时间，写入后10分钟过期
            .recordStats() //统计缓存命中率
            .build();


    @Bean
    UnipushService unipushService() {
        return new UnipushServiceImpl();
    }

    @Bean
    MessageTemplate messageTemplate() {
        return new MessageTemplate();
    }
}
