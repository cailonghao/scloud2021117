package com.unipush;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "unipush")
public class UnipushProperties {

    private String appId;

    private String appKey;

    private String appSecret;

    private String masterSecret;

    private String channelId;

    private String channelName;

}
