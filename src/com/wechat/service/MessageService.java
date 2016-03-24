package com.wechat.service;

import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import com.wechat.util.MessageUtil;
import com.wechat.messageResp.TextMessage;

/**
 * 核心服务类
 * 
 * @author huangjxmimi
 * @date 2016-03-15
 */
public class MessageService {
	
  private static String respMessage=null;
  private static String  respContent = "请求处理异常，请稍候尝试！"; 

	public static String processRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		 
		  try
		  {
        // xml请求解析  
        Map<String, String> requestMap = MessageUtil.parseXml(request);  

        // 发送方帐号（open_id）  
        String fromUserName = requestMap.get("FromUserName");  
        // 公众帐号  
        String toUserName = requestMap.get("ToUserName");  
        // 消息类型  
        String msgType = requestMap.get("MsgType");  
        // 文本消息内容
        String textContent = requestMap.get("Content");  
        // 回复文本消息  
        TextMessage textMessage = new TextMessage();  
        textMessage.setToUserName(fromUserName);  
        textMessage.setFromUserName(toUserName);  
        textMessage.setCreateTime(new Date().getTime());  
        textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);  
        textMessage.setFuncFlag(0);  

        // 文本消息  
        if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {  
        	if( MessageUtil.isQqFace(textContent))
        	{
        		respContent=textContent;
        	}
        	else if(textContent.equals("傻逼"))
            {
            	respContent="请不要骂人，骂人的才是傻逼";
            }
            else if(textContent.equals("操你妈"))
            {
            	respContent ="请注意素质";
            }
            else
            {
            	switch(textContent)
            	{
            	case "1": wether();break;
            	case "2": busServer();break;
            	case "3": localTravel();break;
            	case "4": songs();break;
            	case "5": games();break;
            	case "6": FMs();break;
            	case "7": Faces();break;
            	case "8": Chats();break;
            	case "？": Helps();break;
            	default:Eles();break;
            	}
            }
        }  
        // 图片消息  
        else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {  
            respContent = "您发送的是图片消息！";  
        }  
        // 地理位置消息  
        else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {  
            respContent = "您发送的是地理位置消息！";  
        }  
        // 链接消息  
        else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {  
            respContent = "您发送的是链接消息！";  
        }  
        // 音频消息  
        else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {  
            respContent = "您发送的是音频消息！";  
        }  
        // 事件推送  
        else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {  
            // 事件类型  
            String eventType = requestMap.get("Event");  
            // 订阅  
            if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {  
            	StringBuffer buffer = new StringBuffer();  
            	buffer.append("谢谢您的关注！").append("\n\n");  
                buffer.append("您好，我是小q，请回复数字选择服务：").append("\n\n");  
                buffer.append("1  天气预报").append("\n");  
                buffer.append("2  公交查询").append("\n");  
                buffer.append("3  周边搜索").append("\n");  
                buffer.append("4  歌曲点播").append("\n");  
                buffer.append("5  经典游戏").append("\n");  
                buffer.append("6  美女电台").append("\n");  
                buffer.append("7  人脸识别").append("\n");  
                buffer.append("8  聊天唠嗑").append("\n\n");  
                buffer.append("回复“?”显示此帮助菜单");  
                String tmp = new String(buffer);
                respContent = tmp;
            }  
            // 取消订阅  
            else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {  
                // TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息  
            }  
            // 自定义菜单点击事件  
            else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {  
                // TODO 自定义菜单权没有开放，暂不处理该类消息  
            	String eventKey = requestMap.get("EventKey"); 
            	 if (eventKey.equals("12")) {  
                     respContent = "公交查询菜单项被点击！";  
                 } else if (eventKey.equals("13")) {  
                     respContent = "周边搜索菜单项被点击！";  
                 } else if (eventKey.equals("14")) {  
                     respContent = "历史上的今天菜单项被点击！";  
                 } else if (eventKey.equals("21")) {  
                     respContent = "歌曲点播菜单项被点击！";  
                 } else if (eventKey.equals("22")) {  
                     respContent = "经典游戏菜单项被点击！";  
                 } else if (eventKey.equals("23")) {  
                     respContent = "美女电台菜单项被点击！";  
                 } else if (eventKey.equals("24")) {  
                     respContent = "人脸识别菜单项被点击！";  
                 } else if (eventKey.equals("25")) {  
                     respContent = "聊天唠嗑菜单项被点击！";  
                 } else if (eventKey.equals("31")) {  
                     respContent = "Q友圈菜单项被点击！";  
                 } else if (eventKey.equals("32")) {  
                     respContent = "电影排行榜菜单项被点击！";  
                 } else if (eventKey.equals("33")) {  
                     respContent = "幽默笑话菜单项被点击！";  
                 }  
            }  
        }  

        textMessage.setContent(respContent);  
        respMessage = MessageUtil.textMessageToXml(textMessage);  
    } 
	
	catch (Exception e) {  
        e.printStackTrace();  
	}
    return respMessage;  
	}
	public static void wether() {
		// TODO Auto-generated method stub
		respContent ="天气预报";
	}
	public static void busServer() {
		// TODO Auto-generated method stub
		respContent ="公交查询";
	}
	public static void localTravel() {
		// TODO Auto-generated method stub
		respContent ="周边搜索";
	}
	public static void songs() {
		// TODO Auto-generated method stub
		respContent ="歌曲点播";
	}
	public static void games() {
		// TODO Auto-generated method stub
		respContent ="经典游戏";
	}
	public static void FMs() {
		// TODO Auto-generated method stub
		respContent ="美女电台";
	}
	public static void Faces() {
		// TODO Auto-generated method stub
		respContent ="人脸识别";
	}
	public static void Chats() {
		// TODO Auto-generated method stub
		respContent ="聊天唠嗑";
	}
	public static void Helps() {
		// TODO Auto-generated method stub
		respContent ="帮助";
	}
	public static void Eles() {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();  
		buffer.append("我没有看懂您输入的内容,").append("\n");  
        buffer.append("请回复数字选择服务：").append("\n\n");  
        buffer.append("1  天气预报").append("\n");  
        buffer.append("2  公交查询").append("\n");  
        buffer.append("3  周边搜索").append("\n");  
        buffer.append("4  歌曲点播").append("\n");  
        buffer.append("5  经典游戏").append("\n");  
        buffer.append("6  美女电台").append("\n");  
        buffer.append("7  人脸识别").append("\n");  
        buffer.append("8  聊天唠嗑").append("\n\n");  
        buffer.append("回复“?”显示此帮助菜单");  
        String tmp = new String(buffer);
        respContent = tmp;
	}
}
