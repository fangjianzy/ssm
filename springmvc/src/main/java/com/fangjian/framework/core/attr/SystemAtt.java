package com.fangjian.framework.core.attr;
/**   
 * 类名称：SystemAtt   </br>
 * 类描述： 全局变量  </br>
 * 创建人：fangjian </br>
 * 创建时间：2016年1月20日 下午12:53:23   </br>
 * 修改人：fangjian </br>
 * 修改时间：2016年1月20日 下午12:53:23   </br>
 * 修改备注：   </br>
 * @version    </br>
 */
public class SystemAtt {

	private String image_service;
	
	private String appname = "摇钱树互联网金融平台";
	
	public String getAppname() {
		return appname;
	}

	public void setAppname(String appname) {
		this.appname = appname;
	}

	public String getImage_service() {
		return image_service;
	}

	public void setImage_service(String image_service) {
		this.image_service = image_service;
	}

}

