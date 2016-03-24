package com.wechat.action;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.wechat.service.MessageService;
import com.wechat.util.SignUtil;
/** 
 * ������������ 
 *  
 * @author huangjxmimi
 * @date   huangjxmimi
 */  


public class messageInterface extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String signature;
	private String timestamp;
	private String nonce;
	private String echostr;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		/** ��ȡ���յ���xml��Ϣ */
		// ΢�ż���ǩ��
		signature = request.getParameter("signature");
		// ʱ���
		timestamp = request.getParameter("timestamp");
		// �����
		nonce = request.getParameter("nonce");
		// ����ַ���
		echostr = request.getParameter("echostr");
		
		PrintWriter out = response.getWriter();
		
		if(SignUtil.checkSignature(signature, timestamp, nonce))
		{
			out.print(echostr); 
		}
		 out.close();  
	        out = null;  
	}

	

	// ͨ������signature���������У�飬��У��ɹ���ԭ������echostr����ʾ����ɹ����������ʧ��

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	/** 
     * ����΢�ŷ�������������Ϣ 
     */  
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        // TODO ��Ϣ�Ľ��ա�������Ӧ  
        // ��������Ӧ�ı��������ΪUTF-8����ֹ�������룩  
        request.setCharacterEncoding("UTF-8");  
        response.setCharacterEncoding("UTF-8");  
  
        // ���ú���ҵ���������Ϣ��������Ϣ  
        String respMessage = MessageService.processRequest(request);  
          
        // ��Ӧ��Ϣ  
        PrintWriter out = response.getWriter();  
        out.print(respMessage);  
        out.close();  
    	
    }  

    
	public String getSignatuee() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public void setNonce(String nonce) {
		this.nonce = nonce;
	}

	public String getNonce() {
		return nonce;
	}

	public String getEchostr() {
		return echostr;
	}

	public void setEchostr(String echostr) {
		this.echostr = echostr;
	}
}
