package com.wxgzh.demo.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//{"access_token":"40_oR6LgznpXtyUblEnNwRYs2IhZRrXHGnEKJyhLnZFRUeNXsUMdLJtP55Kpu4x9QiiePazDaiUtJifckXaHmIutAWI__00EfveSD_UfdU_h_sPok7k9_Gk8xo8kG0QVb7d3nYVMasrTrwXvzM5KSIgAGAAIY","expires_in":7200}
// 40_oR6LgznpXtyUblEnNwRYs2IhZRrXHGnEKJyhLnZFRUeNXsUMdLJtP55Kpu4x9QiiePazDaiUtJifckXaHmIutAWI__00EfveSD_UfdU_h_sPok7k9_Gk8xo8kG0QVb7d3nYVMasrTrwXvzM5KSIgAGAAIY

/**
 * token   cailonghaowxtoken
 */
@RequestMapping("/wx")
@RestController
public class WxController {

    public static String appId = "wx8c7cba87d761250d";
    public static String appSecret = "affe27ac2a665c9b2ae6aee981eba050";

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/getAccessToken.do")
    public String getAccessToken() {
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appId + "&secret=" + appSecret;
        try {
            //HttpEntity<MultiValueMap<String, Object>> req = new HttpEntity<>(canshu, headers);
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            String json = response.getBody();
            System.out.println(json);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(json);
        } catch (Exception e) {
            throw new RestClientException("快电请求失败:{}", e);
        }
        return "";
    }
}
