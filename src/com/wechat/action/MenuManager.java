package com.wechat.action;

import com.wechat.MenuPojo.AccessToken;
import com.wechat.MenuPojo.Button;
import com.wechat.MenuPojo.CommonButton;
import com.wechat.MenuPojo.ComplexButton;
import com.wechat.MenuPojo.Menu;
import com.wechat.MenuPojo.ViewButton;
import com.wechat.util.MenuUtil;

/** 
 * �˵��������� 
 *  
 * @author huangjxmimi
 * @date 2016-03-22
 */  
public class MenuManager {
         

	  
    public static void main(String[] args) {  
        // �������û�Ψһƾ֤  
        String appId = "wxfc679ec12500bb9c";  
        // �������û�Ψһƾ֤��Կ  
        String appSecret = "0c9b85989432bee7406a30f98d458d50";  
  
        // ���ýӿڻ�ȡaccess_token  
        AccessToken at = MenuUtil.getAccessToken(appId, appSecret);  
  
        if (null != at) {  
            // ���ýӿڴ����˵�  
            int result = MenuUtil.createMenu(getMenu(), at.getToken());  
  
            // �жϲ˵��������  
            if (0 == result)  
                System.out.println("�˵������ɹ���");  
            else  
            	System.out.println("�˵�����ʧ�ܣ������룺" + result);  
        }  
    }  
    private static Menu getMenu() 
    {
    	  ViewButton  btn11=new ViewButton();
    	  btn11.setName("ʹ�ð���");
          btn11.setType("view");
          btn11.setUrl("http://120.25.173.122/wcschool");
          CommonButton btn12 = new CommonButton();  
          btn12.setName("������ѯ");  
          btn12.setType("click");  
          btn12.setKey("12");  
    
          CommonButton btn13 = new CommonButton();  
          btn13.setName("�ܱ�����");  
          btn13.setType("click");  
          btn13.setKey("13");  
    
          CommonButton btn14 = new CommonButton();  
          btn14.setName("��ʷ�ϵĽ���");  
          btn14.setType("click");  
          btn14.setKey("14");  
    
          CommonButton btn21 = new CommonButton();  
          btn21.setName("�����㲥");  
          btn21.setType("click");  
          btn21.setKey("21");  
    
          CommonButton btn22 = new CommonButton();  
          btn22.setName("������Ϸ");  
          btn22.setType("click");  
          btn22.setKey("22");  
    
          CommonButton btn23 = new CommonButton();  
          btn23.setName("��Ů��̨");  
          btn23.setType("click");  
          btn23.setKey("23");  
    
          CommonButton btn24 = new CommonButton();  
          btn24.setName("����ʶ��");  
          btn24.setType("click");  
          btn24.setKey("24");  
    
          CommonButton btn25 = new CommonButton();  
          btn25.setName("�������");  
          btn25.setType("click");  
          btn25.setKey("25");  
    
          CommonButton btn31 = new CommonButton();  
          btn31.setName("Q��Ȧ");  
          btn31.setType("click");  
          btn31.setKey("31");  
    
          CommonButton btn32 = new CommonButton();  
          btn32.setName("��Ӱ���а�");  
          btn32.setType("click");  
          btn32.setKey("32");  
    
          CommonButton btn33 = new CommonButton();  
          btn33.setName("��ĬЦ��");  
          btn33.setType("click");  
          btn33.setKey("33");  
    
          ComplexButton mainBtn1 = new ComplexButton();  
          mainBtn1.setName("��������");  
          mainBtn1.setSub_button(new Button[] { btn11, btn12, btn13, btn14 });  
    
          ComplexButton mainBtn2 = new ComplexButton();  
          mainBtn2.setName("������վ");  
          mainBtn2.setSub_button(new CommonButton[] { btn21, btn22, btn23, btn24, btn25 });  
    
          ComplexButton mainBtn3 = new ComplexButton();  
          mainBtn3.setName("��������");  
          mainBtn3.setSub_button(new CommonButton[] { btn31, btn32, btn33 });  
    
          /** 
           * ���ǹ��ں�Ŀǰ�Ĳ˵��ṹ��ÿ��һ���˵����ж����˵���<br> 
           *  
           * ��ĳ��һ���˵���û�ж����˵��������menu����ζ����أ�<br> 
           * ���磬������һ���˵���ǡ��������顱����ֱ���ǡ���ĬЦ��������ômenuӦ���������壺<br> 
           * menu.setButton(new Button[] { mainBtn1, mainBtn2, btn33 }); 
           */  
    	Menu menu = new Menu(); 	
    	 menu.setButton(new Button[] { mainBtn1, mainBtn2, mainBtn3 }); 
		return menu; 
    }
}
