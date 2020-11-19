DROP TABLE IF EXISTS `product`;

create table `product`
(
    `pro_id`          bigint(20)     NOT NULL auto_increment,
    `pro_title`       varchar(255)   NOT NULL COMMENT '名称',
    `pro_status`         varchar(255) DEFAULT NULL COMMENT '图片',
    `pro_type`         varchar(255) DEFAULT NULL COMMENT '分类',
    `pro_pic`         varchar(255) DEFAULT NULL COMMENT '图片',
    `pro_price`       decimal(10, 2) NOT NULL COMMENT '原价',
    `pro_curPrice`    decimal(10, 2) NOT NULL COMMENT '现价',
    `pro_sort`        int(5)       DEFAULT NULL COMMENT '排序',
    `pro_sale`        int(5)       DEFAULT NULL COMMENT '销量',
    `pro_description` varchar(255) COMMENT '商品描述',
    `pro_stock`       int(5)       DEFAULT NULL COMMENT '库存',
    primary key (`id`)
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

DROP TABLE IF EXISTS `product_category`;

create table `product_category`
(
    `cate_id`   int   NOT NULL auto_increment
    `cate_name` varchar(255) DEFAULT NULL comment '名称',
    `cate_type` int DEFAULT NULL comment '编号',
    `cate_pid` varchar(255) DEFAULT NULL comment '父ID',
    `create_time`  timestamp NOT NULL default current_timestamp comment '创建时间',
    `update_time` timestamp NOT NULL default current_timestamp on update current_timestamp comment '修改时间',
    primary key (`id`)
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;






