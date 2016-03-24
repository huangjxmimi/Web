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
 * 核心请求处理类 
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
		/** 读取接收到的xml消息 */
		// 微信加密签名
		signature = request.getParameter("signature");
		// 时间戳
		timestamp = request.getParameter("timestamp");
		// 随机数
		nonce = request.getParameter("nonce");
		// 随机字符串
		echostr = request.getParameter("echostr");
		
		PrintWriter out = response.getWriter();
		
		if(SignUtil.checkSignature(signature, timestamp, nonce))
		{
			out.print(echostr); 
		}
		 out.close();  
	        out = null;  
	}

	

	// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败

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
     * 处理微信服务器发来的消息 
     */  
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        // TODO 消息的接收、处理、响应  
        // 将请求、响应的编码均设置为UTF-8（防止中文乱码）  
        request.setCharacterEncoding("UTF-8");  
        response.setCharacterEncoding("UTF-8");  
  
        // 调用核心业务类接收消息、处理消息  
        String respMessage = MessageService.processRequest(request);  
          
        // 响应消息  
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
