package com.fangjian.framework.core.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.fangjian.framework.common.exception.BusinessException;
import com.fangjian.framework.common.exception.SystemException;


/**   
 * 类名称：MyHandlerExceptionResolver   </br>
 * 类描述：   </br>
 * 创建人：fangjian </br>
 * 创建时间：2016年1月20日 上午10:40:42   </br>
 * 修改人：fangjian </br>
 * 修改时间：2016年1月20日 上午10:40:42   </br>
 * 修改备注：   </br>
 * @version    </br>
 */
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {
	
	@Override  
    public ModelAndView resolveException(HttpServletRequest request,HttpServletResponse response, Object handler, Exception ex) {  
		
		Map<String, Object> model = new HashMap<String, Object>();  
        model.put("ex", ex);  
        // 根据不同错误转向不同页面  
        if(ex instanceof BusinessException) {  
            return new ModelAndView("error/errorpage", model);  
        }else if(ex instanceof SystemException) {  
            return new ModelAndView("error/errorpage", model);  
        }else {  
            return new ModelAndView("error/errorpage", model);  
        }  
        
    }  
	
}

