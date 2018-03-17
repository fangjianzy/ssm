package com.fangjian.framework.core.email;

import java.util.List;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

/**   
 * 类名称：EmailAbstract   </br>
 * 类描述：   </br>
 * 创建人：fangjian </br>
 * 创建时间：2016年6月24日 下午4:12:13   </br>
 * 修改人：fangjian </br>
 * 修改时间：2016年6月24日 下午4:12:13   </br>
 * 修改备注：   </br>
 * @version    </br>
 */
public abstract class EmailAbstract {

	 	protected String from;  
	    protected String subject;  
	    protected JavaMailSender sender;  
	    protected FreeMarkerConfigurer freeMarkerConfigurer=null; //FreeMarker的技术类     
	       
	    public String getFrom() {  
	        return from;  
	    }  
	  
	    public void setFrom(String from) {  
	        this.from = from;  
	    }  
	  
	    public String getSubject() {  
	        return subject;  
	    }  
	  
	    public void setSubject(String subject) {  
	        this.subject = subject;  
	    }  
	  
	    public JavaMailSender getSender() {  
	        return sender;  
	    }  
	  
	    public void setSender(JavaMailSender sender) {  
	        this.sender = sender;  
	    }  
	      
	    public void setFreeMarkerConfigurer(FreeMarkerConfigurer freeMarkerConfigurer) {     
	    	this.freeMarkerConfigurer = freeMarkerConfigurer;     
	    }  
	    /** 
	     * 发送单个html格式邮件 
	     */  
	    public abstract void sendEmail(String content,String address); 
	    
	    /** 
	     * 批量发送html格式邮件 
	     */  
	    public abstract void sendBatchEmail(String content,List<String> address);  

}

