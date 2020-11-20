package com.fish.product.controller;

import com.fish.product.pojo.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Date 2020/11/19 12:31
 * @Created by cai
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @RequestMapping("/getProduct.do")
    public Map<String, Object> getProduct(@RequestParam Long id) {
        Map<String, Object> map = new HashMap<>();
        Product p = new Product();
        p.setPro_id(id);
        p.setPro_title("好伙伴");
        p.setPro_price(100.0);
        p.setPro_stock(10);
        map.put("pro", p);
        map.put("message", "success");
        return map;
    }
}
