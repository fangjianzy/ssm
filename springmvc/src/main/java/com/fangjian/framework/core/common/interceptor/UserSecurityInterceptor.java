package com.fangjian.framework.core.common.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fangjian.framework.common.GlobalConstant;



/**   
 * 类名称：UserSecurityInterceptor   </br>
 * 类描述：用户登录验证拦截器   </br>
 * 创建人：fangjian </br>
 * 创建时间：2016年1月20日 上午10:32:16   </br>
 * 修改人：fangjian </br>
 * 修改时间：2016年1月20日 上午10:32:16   </br>
 * 修改备注：   </br>
 * @version    </br>
 */
public class UserSecurityInterceptor implements HandlerInterceptor{
	private final static Logger log= Logger.getLogger(UserSecurityInterceptor.class);
    private List<String> excludedUrls;
    
    @Override
    public void afterCompletion(HttpServletRequest arg0,
            HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
    	//log.info("==============执行顺序: 3、afterCompletion===========");  
        
    }

   

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
            Object arg2, ModelAndView arg3) throws Exception {
    	//log.info("==============执行顺序: 2、postHandle================"); 
        
    }

    @Override
    public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
            Object arg2) throws Exception {
        
        String requestUri = arg0.getRequestURI();
        for (String url : excludedUrls) {
            if (requestUri.endsWith(url)|| requestUri.endsWith("html")) {
                return true;
            }
        }
        
        HttpSession session = arg0.getSession();
        if (session.getAttribute(GlobalConstant.SESSION_PFUSER) == null) {
        	//log.info(requestUri+"验证不合格!=========================>");
        	//没有授权的情况
        	log.info("拦截到没有授权的情况！进行授权!=======>:"+requestUri);
        	String URL=arg0.getContextPath() + "/system/tologin.do";
        			//GetWeiXinCode.getCodeRequest();/system/tologin.do
        	//服务器配置
        	//arg1.sendRedirect(URL); 
        	//return false;
        	
        	//log.info("本地测试：=================去掉权限验证的限制!===========================================================================>");
        	//arg1.sendRedirect(arg0.getContextPath() + "/weiXinSystem/index.html");
            //本地模拟测试用一下这段
        	
        	return true;
        }else{
        	log.info(requestUri+"验证合格!");
        	return true;
        }
        
    }
    
    public List<String> getExcludedUrls() {
        return excludedUrls;
    }

    public void setExcludedUrls(List<String> excludedUrls) {
        this.excludedUrls = excludedUrls;
    }
}

