package com.fangjian.framework.core.user;

import java.io.Serializable;

/**   
 * 类名称：Iepfuser   </br>
 * 类描述：  平台用户实体</br>
 * 创建人：fangjian </br>
 * 创建时间：2016年1月20日 下午3:02:35   </br>
 * 修改人：fangjian </br>
 * 修改时间：2016年1月20日 下午3:02:35   </br>
 * 修改备注：   </br>
 * @version    </br>
 */
public class Iepfuser implements Serializable{

	/**
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）
	 *
	 * @since 1.0.0
	 */
	
	private static final long serialVersionUID = 1L;

	private int id;
	
	private String username;
	
	private String account;
	
	private String password;
	
	private String tel;
	
	private String idcard;
	
	
	
	
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	
	

}

