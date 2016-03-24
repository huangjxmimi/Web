package com.wechat.messageReq;
/** 
 * 音频消息 
 *  
 * @author huangjxmimi
 * @date 2016-03-15 
 */  
public class AudioMessage {
	   // 媒体ID  
    private String MediaId;  
    // 语音格式  
    private String Format;
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	public String getFormat() {
		return Format;
	}
	public void setFormat(String format) {
		Format = format;
	}  
}
