package com.fangjian.framework.core.common;

import javax.servlet.http.HttpServletRequest;

import com.fangjian.framework.common.GlobalConstant;

/**   
 * 类名称：BaseEshopController   </br>
 * 类描述：   </br>
 * 创建人：fangjian </br>
 * 创建时间：2016年6月17日 上午9:50:11   </br>
 * 修改人：fangjian </br>
 * 修改时间：2016年6月17日 上午9:50:11   </br>
 * 修改备注：   </br>
 * @version    </br>
 */
public class BaseEshopController {

	public Object getSession_pfuser(HttpServletRequest request){
		Object ob = request.getSession().getAttribute(GlobalConstant.SESSION_PFUSER);
		return ob;
	}

}

