package com.fangjian.framework.core.cenum;
/**   
 * 类名称：SexTypeEnum   </br>
 * 类描述：   </br>
 * 创建人：fangjian </br>
 * 创建时间：2016年1月26日 下午1:33:50   </br>
 * 修改人：fangjian </br>
 * 修改时间：2016年1月26日 下午1:33:50   </br>
 * 修改备注：   </br>
 * @version    </br>
 */
public enum SexTypeEnum {
	
	boby(1),girl(2);
	
	private int content;

	public int getContent() {
		return content;
	}
	
	private SexTypeEnum(int content){
		this.content= content;
	}
}

