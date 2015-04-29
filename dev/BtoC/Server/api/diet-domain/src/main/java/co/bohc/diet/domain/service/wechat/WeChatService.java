package co.bohc.diet.domain.service.wechat;

import java.util.Map;

import co.bohc.diet.domain.common.utils.MessageUtils;

public class WeChatService {

    public static Map<String, String> processRequest(String msg) throws Exception {
        String respMessage = null;
        // try {
        // 默认返回的文本消息内容
        String respContent = "请求处理异常，请稍候尝试！";

        // xml请求解析
        Map<String, String> requestMap = MessageUtils.parseXml(msg);

        System.out.println("Event==" + requestMap.get("Event"));

        // 发送方帐号（open_id）
        String fromUserName = requestMap.get("FromUserName");
        // 公众帐号
        String toUserName = requestMap.get("ToUserName");
        // 消息类型
        String msgType = requestMap.get("MsgType");

        // 回复文本消息
        // TextMessage textMessage = new TextMessage();
        // textMessage.setToUserName(fromUserName);
        // textMessage.setFromUserName(toUserName);
        // textMessage.setCreateTime(new Date().getTime());
        // textMessage.setMsgType(MessageUtils.RESP_MESSAGE_TYPE_TEXT);
        // textMessage.setFuncFlag(0);
        //
        // // 文本消息
        // if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
        // String content = requestMap.get("Content");
        // respContent = "Sunlight提示：您发送的是文本消息！内容是："+content;
        // }
        // // 图片消息
        // else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
        // respContent = "Sunlight提示：您发送的是图片消息！";
        // }
        // // 地理位置消息
        // else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
        // respContent = "Sunlight提示：您发送的是地理位置消息！";
        // }
        // // 链接消息
        // else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
        // respContent = "Sunlight提示：您发送的是链接消息！";
        // }
        // // 音频消息
        // else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
        // respContent = "Sunlight提示：您发送的是音频消息！";
        // }
        // // 事件推送
        // else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
        // // 事件类型
        // String eventType = requestMap.get("Event");
        // // 自定义菜单点击事件
        // if (eventType.equalsIgnoreCase(MessageUtil.EVENT_TYPE_CLICK)) {
        // // 事件KEY值，与创建自定义菜单时指定的KEY值对应
        // String eventKey = requestMap.get("EventKey");
        // System.out.println("EventKey="+eventKey);
        // respContent = "Sunlight提示：您点击的菜单KEY是"+eventKey;
        // }
        // }
        //
        // textMessage.setContent(respContent);
        // respMessage = MessageUtil.textMessageToXml(textMessage);
        // } catch (Exception e) {
        // e.printStackTrace();
        // System.out.println(e);
        // respMessage="有异常了。。。";
        // }
        return requestMap;
    }
}
