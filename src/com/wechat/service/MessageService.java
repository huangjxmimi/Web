package com.wechat.service;

import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import com.wechat.util.MessageUtil;
import com.wechat.messageResp.TextMessage;

/**
 * ���ķ�����
 * 
 * @author huangjxmimi
 * @date 2016-03-15
 */
public class MessageService {
	
  private static String respMessage=null;
  private static String  respContent = "�������쳣�����Ժ��ԣ�"; 

	public static String processRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		 
		  try
		  {
        // xml�������  
        Map<String, String> requestMap = MessageUtil.parseXml(request);  

        // ���ͷ��ʺţ�open_id��  
        String fromUserName = requestMap.get("FromUserName");  
        // �����ʺ�  
        String toUserName = requestMap.get("ToUserName");  
        // ��Ϣ����  
        String msgType = requestMap.get("MsgType");  
        // �ı���Ϣ����
        String textContent = requestMap.get("Content");  
        // �ظ��ı���Ϣ  
        TextMessage textMessage = new TextMessage();  
        textMessage.setToUserName(fromUserName);  
        textMessage.setFromUserName(toUserName);  
        textMessage.setCreateTime(new Date().getTime());  
        textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);  
        textMessage.setFuncFlag(0);  

        // �ı���Ϣ  
        if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {  
        	if( MessageUtil.isQqFace(textContent))
        	{
        		respContent=textContent;
        	}
        	else if(textContent.equals("ɵ��"))
            {
            	respContent="�벻Ҫ���ˣ����˵Ĳ���ɵ��";
            }
            else if(textContent.equals("������"))
            {
            	respContent ="��ע������";
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
            	case "��": Helps();break;
            	default:Eles();break;
            	}
            }
        }  
        // ͼƬ��Ϣ  
        else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {  
            respContent = "�����͵���ͼƬ��Ϣ��";  
        }  
        // ����λ����Ϣ  
        else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {  
            respContent = "�����͵��ǵ���λ����Ϣ��";  
        }  
        // ������Ϣ  
        else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {  
            respContent = "�����͵���������Ϣ��";  
        }  
        // ��Ƶ��Ϣ  
        else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {  
            respContent = "�����͵�����Ƶ��Ϣ��";  
        }  
        // �¼�����  
        else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {  
            // �¼�����  
            String eventType = requestMap.get("Event");  
            // ����  
            if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {  
            	StringBuffer buffer = new StringBuffer();  
            	buffer.append("лл���Ĺ�ע��").append("\n\n");  
                buffer.append("���ã�����Сq����ظ�����ѡ�����").append("\n\n");  
                buffer.append("1  ����Ԥ��").append("\n");  
                buffer.append("2  ������ѯ").append("\n");  
                buffer.append("3  �ܱ�����").append("\n");  
                buffer.append("4  �����㲥").append("\n");  
                buffer.append("5  ������Ϸ").append("\n");  
                buffer.append("6  ��Ů��̨").append("\n");  
                buffer.append("7  ����ʶ��").append("\n");  
                buffer.append("8  �������").append("\n\n");  
                buffer.append("�ظ���?����ʾ�˰����˵�");  
                String tmp = new String(buffer);
                respContent = tmp;
            }  
            // ȡ������  
            else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {  
                // TODO ȡ�����ĺ��û����ղ������ںŷ��͵���Ϣ����˲���Ҫ�ظ���Ϣ  
            }  
            // �Զ���˵�����¼�  
            else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {  
                // TODO �Զ���˵�Ȩû�п��ţ��ݲ����������Ϣ  
            	String eventKey = requestMap.get("EventKey"); 
            	 if (eventKey.equals("12")) {  
                     respContent = "������ѯ�˵�������";  
                 } else if (eventKey.equals("13")) {  
                     respContent = "�ܱ������˵�������";  
                 } else if (eventKey.equals("14")) {  
                     respContent = "��ʷ�ϵĽ���˵�������";  
                 } else if (eventKey.equals("21")) {  
                     respContent = "�����㲥�˵�������";  
                 } else if (eventKey.equals("22")) {  
                     respContent = "������Ϸ�˵�������";  
                 } else if (eventKey.equals("23")) {  
                     respContent = "��Ů��̨�˵�������";  
                 } else if (eventKey.equals("24")) {  
                     respContent = "����ʶ��˵�������";  
                 } else if (eventKey.equals("25")) {  
                     respContent = "������ྲ˵�������";  
                 } else if (eventKey.equals("31")) {  
                     respContent = "Q��Ȧ�˵�������";  
                 } else if (eventKey.equals("32")) {  
                     respContent = "��Ӱ���а�˵�������";  
                 } else if (eventKey.equals("33")) {  
                     respContent = "��ĬЦ���˵�������";  
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
		respContent ="����Ԥ��";
	}
	public static void busServer() {
		// TODO Auto-generated method stub
		respContent ="������ѯ";
	}
	public static void localTravel() {
		// TODO Auto-generated method stub
		respContent ="�ܱ�����";
	}
	public static void songs() {
		// TODO Auto-generated method stub
		respContent ="�����㲥";
	}
	public static void games() {
		// TODO Auto-generated method stub
		respContent ="������Ϸ";
	}
	public static void FMs() {
		// TODO Auto-generated method stub
		respContent ="��Ů��̨";
	}
	public static void Faces() {
		// TODO Auto-generated method stub
		respContent ="����ʶ��";
	}
	public static void Chats() {
		// TODO Auto-generated method stub
		respContent ="�������";
	}
	public static void Helps() {
		// TODO Auto-generated method stub
		respContent ="����";
	}
	public static void Eles() {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();  
		buffer.append("��û�п��������������,").append("\n");  
        buffer.append("��ظ�����ѡ�����").append("\n\n");  
        buffer.append("1  ����Ԥ��").append("\n");  
        buffer.append("2  ������ѯ").append("\n");  
        buffer.append("3  �ܱ�����").append("\n");  
        buffer.append("4  �����㲥").append("\n");  
        buffer.append("5  ������Ϸ").append("\n");  
        buffer.append("6  ��Ů��̨").append("\n");  
        buffer.append("7  ����ʶ��").append("\n");  
        buffer.append("8  �������").append("\n\n");  
        buffer.append("�ظ���?����ʾ�˰����˵�");  
        String tmp = new String(buffer);
        respContent = tmp;
	}
}
