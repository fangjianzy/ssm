package com.fangjian.framework.core.view.freemark;

import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;


/**   
 * 类名称：CustomFreeMarkerViewResolver   </br>
 * 类描述：   </br>
 * 创建人：fangjian </br>
 * 创建时间：2016年1月20日 上午10:36:37   </br>
 * 修改人：fangjian </br>
 * 修改时间：2016年1月20日 上午10:36:37   </br>
 * 修改备注：   </br>
 * @version    </br>
 */
public class CustomFreeMarkerViewResolver extends FreeMarkerViewResolver{

	   public CustomFreeMarkerViewResolver() {
	      setViewClass( requiredViewClass() );
	   }

	   /**
	    * Requires {@link FreeMarkerView}.
	    */
	   @Override
	   protected Class requiredViewClass(){
	      return CustomFreeMarkerView.class;
	   }
	}

