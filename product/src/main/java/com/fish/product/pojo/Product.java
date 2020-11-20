package com.fish.product.pojo;

import lombok.Data;

/**
 * @Description TODO
 * @Date 2020/11/19 12:28
 * @Created by cai
 */
@Data
public class Product {

    private Long pro_id;
    private String pro_title;
    private Integer pro_status;
    private Integer pro_type;
    private String pro_pic;
    private Double pro_price;
    private Double pro_curPrice;
    private Integer pro_sort;
    private Integer pro_sale;
    private String pro_description;
    private Integer pro_stock;

}
