package com.unipush;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Message {

    /**
     * 消息类型  1 通知 2 打开其他网页 3 透传模板 4 打开app网页
     */
    private Integer type;
    /**
     * 单推  批量推  全部
     */
    private Integer pushMode;

    /**
     * clientId集合  单推一个 群推,隔开
     */
    private String clientIds;
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 图标 配置通知栏图标，需要在客户端开发时嵌入，默认为push.png
     */
    private String icon;
    /**
     * 网页地址
     */
    private String webUrl;
    /**
     * app网页
     */
    private String appUrl;
    /**
     * 铃声 配置自定义铃声(文件名，不需要后缀名)，需要在客户端开发时嵌入后缀名为.ogg的铃声文件
     */
    private String ring;
    /**
     * 铃声
     */
    private Boolean isRing = false;
    /**
     * 震动
     */
    private Boolean isVibrate = false;
    /**
     * 可清除
     */
    private Boolean isClear = true;
    /**
     * 消息标记 用来覆盖该条消息
     */
    private Integer rand;
    /**
     * 展开样式设计  1默认样式  2大图样式 需配置bigImageUrl  3 长文本样式 需配置bigText
     */
    private Integer styleType = 1;
    /**
     * 图片
     */
    private String bigImageUrl;
    /**
     * 长文本
     */
    private String bigText;
}
