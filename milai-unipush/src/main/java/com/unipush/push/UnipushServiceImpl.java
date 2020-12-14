package com.unipush.push;

import com.unipush.Message;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;


@Getter
@Setter
@Slf4j
public class UnipushServiceImpl implements UnipushService {
    private static String url = "http://api.getui.com/apiex.htm";
    @Value("unipush.appId")
    private String appId;
    @Value("unipush.appKey")
    private String appKey;
    @Value("unipush.appSecret")
    private String appSecret;
    @Value("unipush.masterSecret")
    private String masterSecret;


    @Override
    public void pushTo(Message message) {

    }

    @Override
    public void pushToSingleBatch(Message message) {

    }
}
