package com.unipush.template;


import com.gexin.rp.sdk.template.style.AbstractNotifyStyle;
import com.gexin.rp.sdk.template.style.Style0;
import com.gexin.rp.sdk.template.style.Style6;
import com.unipush.Message;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
@Setter
@Getter
public class PushStyle {

    @Value("unipush.channelId")
    private String channelId;
    @Value("unipush.channelName")
    private String channelName;
    /**
     * Style0 系统样式
     * @link http://docs.getui.com/getui/server/java/template/ 查看效果
     * @return
     */
    public AbstractNotifyStyle getStyle0(Message message) {
        Style0 style = new Style0();
        // 设置通知栏标题与内容
        style.setTitle(message.getTitle());
        style.setText(message.getContent());
        // 配置通知栏图标
        style.setLogo(message.getIcon()); //配置通知栏图标，需要在客户端开发时嵌入，默认为push.png
        // 配置通知栏网络图标
        //style.setLogoUrl("");
        // 配置自定义铃声(文件名，不需要后缀名)，需要在客户端开发时嵌入后缀名为.ogg的铃声文件
        //style.setRingName("sound");
        // 角标, 必须大于0, 个推通道下发有效; 此属性目前仅针对华为 EMUI 4.1 及以上设备有效
        //style.setBadgeAddNum(1);

        // 设置通知是否响铃，震动，或者可清除
        style.setRing(message.getIsRing());
        style.setVibrate(message.getIsVibrate());
        style.setClearable(message.getIsClear());
        style.setChannel(channelId);
        style.setChannelName(channelName);
        style.setChannelLevel(3); //设置通知渠道重要性
        return style;
    }

    /**
     * Style6 展开式通知样式
     * @link http://docs.getui.com/getui/server/java/template/ 查看效果
     * @return
     */
    public  AbstractNotifyStyle getStyle6(Message message) {
        Style6 style = new Style6();
        // 设置通知栏标题与内容
        style.setTitle(message.getTitle());
        style.setText(message.getContent());
        // 配置通知栏图标
        style.setLogo(message.getIcon()); //配置通知栏图标，需要在客户端开发时嵌入
        // 配置通知栏网络图标
        //style.setLogoUrl("");
        // 三种方式选一种
        if(message.getStyleType()==2) {
            style.setBigStyle1(message.getBigImageUrl());
        }else if(message.getStyleType()==3) {
            style.setBigStyle2(message.getBigText());
        }

        // 配置自定义铃声(文件名，不需要后缀名)，需要在客户端开发时嵌入后缀名为.ogg的铃声文件
        style.setRingName(message.getRing());
        // 角标, 必须大于0, 个推通道下发有效; 此属性目前仅针对华为 EMUI 4.1 及以上设备有效
        style.setBadgeAddNum(1);
        // 设置通知是否响铃，震动，或者可清除
        style.setRing(message.getIsRing());
        style.setVibrate(message.getIsVibrate());
        style.setClearable(message.getIsClear());
        style.setChannel(channelId);
        style.setChannelName(channelName);
        style.setChannelLevel(3); //设置通知渠道重要性
        return style;
    }
}
