package com.fangjian.framework.core.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.DispatcherServlet;
/**   
 * 类名称：DispatcherServletHandler   </br>
 * 类描述：   </br>
 * 创建人：fangjian </br>
 * 创建时间：2016年1月20日 下午12:51:27   </br>
 * 修改人：fangjian </br>
 * 修改时间：2016年1月20日 下午12:51:27   </br>
 * 修改备注：   </br>
 * @version    </br>
 */
public class DispatcherServletHandler extends DispatcherServlet {
	
	/***
	 * 日志操作类
	 */
	private static Logger logger = Logger.getLogger(DispatcherServletHandler.class);

	@Override
	protected void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try{
			super.doService(request, response);
		}catch(Exception ex){
			logger.error(ex.getMessage());
		}
	}
}

