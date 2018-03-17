package com.fangjian.framework.core.view;

import java.util.Locale;
import java.util.Map;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

/**   
 * 类名称：PlatformViewResolver   </br>
 * 类描述：  多视图处理器 </br>
 * 创建人：fangjian </br>
 * 创建时间：2016年1月20日 上午10:35:27   </br>
 * 修改人：fangjian </br>
 * 修改时间：2016年1月20日 上午10:35:27   </br>
 * 修改备注：   </br>
 * @version    </br>
 */
public class PlatformViewResolver implements ViewResolver {

	/***
	 * @description 视图处理器集合
	 */
	private Map<String,ViewResolver> resolvers;
	
	public void setResolvers(Map<String, ViewResolver> resolvers) {
		this.resolvers = resolvers;
	}
	
	/***
	 * @description 根据请求的后缀，动态处理视图
	 */
	public View resolveViewName(String viewName,Locale locale) throws Exception{
		View  view = null;
		ViewResolver resolver = null;
		String suffix;
		
		int n=viewName.lastIndexOf(".");
		int end=viewName.lastIndexOf("?");
		
		//取出扩展名
		if(end < 0 ){
			suffix=viewName.substring(n+1);	
		}else{
			suffix=viewName.substring(n+1,end);
		}
		
		if(n!=-1 && !suffix.toLowerCase().equals("do")){
			//freemarker处理方式
			if(!suffix.toLowerCase().equals("do")){
				//取出对应的ViewResolver
				resolver=resolvers.get(suffix);
			}
			if(resolver==null){
				throw new RuntimeException("No ViewResolver for "+suffix);
			}
		}else{
			//freemarker处理方式
			resolver=resolvers.get("jsp");
		}
		view = resolver.resolveViewName(viewName, locale);
		if(view == null){
			view = resolver.resolveViewName("redirect:/", locale);	
		}
		return view;
	}
}

