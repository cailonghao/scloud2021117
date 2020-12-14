package com.unipush.push;

import com.gexin.rp.sdk.template.style.AbstractNotifyStyle;
import com.gexin.rp.sdk.template.style.Style0;
import com.unipush.Message;

public interface UnipushService {

    /**
     * 对单个用户推送消息
     * <p>
     * 场景1：某用户发生了一笔交易，银行及时下发一条推送消息给该用户。
     * <p>
     * 场景2：用户定制了某本书的预订更新，当本书有更新时，需要向该用户及时下发一条更新提醒信息。
     * 这些需要向指定某个用户推送消息的场景，即需要使用对单个用户推送消息的接口。
     */
    void pushTo(Message message);

    /**
     * 批量单推
     * <p>
     * 当单推任务较多时，推荐使用该接口，可以减少与服务端的交互次数。
     */
    void pushToSingleBatch(Message message);

}
