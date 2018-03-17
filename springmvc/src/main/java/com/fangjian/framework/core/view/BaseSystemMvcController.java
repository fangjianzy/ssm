package com.fangjian.framework.core.view;

import javax.servlet.http.HttpServletRequest;

import com.fangjian.framework.common.GlobalConstant;
import com.fangjian.framework.common.util.PublicUtil;

/**   
 * 类名称：BaseSystemMvcController   </br>
 * 类描述：   </br>
 * 创建人：fangjian </br>
 * 创建时间：2016年1月20日 下午2:56:47   </br>
 * 修改人：fangjian </br>
 * 修改时间：2016年1月20日 下午2:56:47   </br>
 * 修改备注：   </br>
 * @version    </br>
 */
public class BaseSystemMvcController {

	/**
	 * 
	* 方法名: getSession_pfuser 
	* 方法描述: 获取后台session中的用户
	* 创建人：fangjian 
	* 创建时间：2016年1月15日 上午10:34:21   
	* 修改人：fangjian   
	* 修改时间：2016年1月15日 上午10:34:21   
	* 修改备注：   
	* 参数 @param request
	* 参数 @return
	* 返回类型 Object
	* throws
	 */
	public Object getSession_pfuser(HttpServletRequest request){
		Object ob = request.getSession().getAttribute(GlobalConstant.SESSION_PFUSER);
		return ob;
	}
	
	/**
	 * 
	* 方法名: getSession_frount_pfuser 
	* 方法描述: 获取前台用户session
	* 创建人：fangjian 
	* 创建时间：2016年1月18日 上午9:29:06   
	* 修改人：fangjian   
	* 修改时间：2016年1月18日 上午9:29:06   
	* 修改备注：   
	* 参数 @param request
	* 参数 @return
	* 返回类型 Object
	* throws
	 */
	public Object getSession_frount_pfuser(HttpServletRequest request){
		Object ob = request.getSession().getAttribute(GlobalConstant.SESSION_MiDDLE_PFUSER);
		return ob;
	}
	
	/**
	 * 
	* 方法名: getIpAdders 
	* 方法描述: 获取当前人IP地址
	* 创建人：fangjian 
	* 创建时间：2016年1月20日 下午2:58:26   
	* 修改人：fangjian   
	* 修改时间：2016年1月20日 下午2:58:26   
	* 修改备注：   
	* 参数 @return
	* 返回类型 String
	* throws
	 */
	public String getIpAdders(){
		
		return PublicUtil.getIp();
	}
}

