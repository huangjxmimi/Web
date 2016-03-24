package com.wechat.messageReq;
/** 
 * 图片消息
 *  
 * @author huangjxmimi
 * @date 2016-03-15 
 */  
public class ImageMessage extends BaseMessage{
          //图片的地址url
	private String picurl;

	public String getPicurl() {
		return picurl;
	}

	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}
}
