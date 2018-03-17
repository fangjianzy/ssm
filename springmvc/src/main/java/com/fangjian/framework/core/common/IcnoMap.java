package com.fangjian.framework.core.common;

import java.util.HashMap;
import java.util.Map;

public class IcnoMap {
	//构造函数初始化的时候静态加载
		public static  Map<String, String> getIcno(){
		    Map<String, String> icno = new HashMap<String, String>();
			icno.put("1", "../libs/icons/page.png");
			icno.put("2", "../libs/icons/item.gif");
			icno.put("3", "../libs/icons/list.png");
			icno.put("4", "../libs/icons/flag.png");
			icno.put("5", "../libs/icons/starshape.png");
			icno.put("6", "../libs/icons/user_group.png");
			icno.put("7", "../libs/icons/user.png");
			icno.put("8", "../libs/icons/user_female.png");
			icno.put("9", "../libs/icons/user_off.gif");
			icno.put("10", "../libs/icons/home.png");
			
			
			//菜单图标
			icno.put("11", "../libs/icons/globe.png");
			icno.put("12", "../libs/icons/stop.png");
			icno.put("13", "../libs/icons/jing.png");
			icno.put("14", "../libs/icons/exit.png");
			icno.put("15", "../libs/icons/folder.png");
			
			icno.put("16", "../libs/icons/tree_close.gif");
			icno.put("17", "../libs/icons/tree_open.gif");
			icno.put("18", "../skin/main/titlebar_arrow.gif");
			
			//父打开和关闭
			icno.put("19", "../skin/main/titlebar_arrow_up.png");
			icno.put("20", "../skin/main/titlebar_arrow_down.png");
			icno.put("21", "../skin/main/titlebar_arrow.gif");
			icno.put("22", "../skin/main/titlebar_arrow_right.png");
			return icno;
		}
}
