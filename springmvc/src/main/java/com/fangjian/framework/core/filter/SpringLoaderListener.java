package com.fangjian.framework.core.filter;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.fangjian.framework.common.util.Config;
import com.fangjian.framework.core.attr.SystemAtt;
/**   
 * 类名称：SpringLoaderListener   </br>
 * 类描述：  系统启动类 </br>
 * 创建人：fangjian </br>
 * 创建时间：2016年1月20日 下午12:50:54   </br>
 * 修改人：fangjian </br>
 * 修改时间：2016年1月20日 下午12:50:54   </br>
 * 修改备注：   </br>
 * @version    </br>
 */
public class SpringLoaderListener extends HttpServlet implements ServletContextListener {
	private final static Logger log= Logger.getLogger(SpringLoaderListener.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		log.info("************* 启动失败！*****************");
		
	}

	@Override
	public void contextInitialized(ServletContextEvent even) {
		log.info("************* 初始化系统配置参数开始！*****************");
		WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(even.getServletContext());
		//WxconfigService wcfg = (WxconfigService) context.getBean("wxconfigService");
		//Wxconfig cfg = wcfg.selectByPrimaryKey(1);
		SystemAtt cfg = new SystemAtt();
		log.info("加载图片服务器地址.............");
		String image_service = Config.getInstance().getValue("image_service");
		cfg.setImage_service(image_service);
		even.getServletContext().setAttribute("cfg", cfg);
		log.info(image_service);
		log.info("************* 初始化系统配置参数结束！*****************");
	}
	
}
