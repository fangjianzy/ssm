package com.fangjian.framework.core.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
/**   
 * 类名称：ApplicationUtil   </br>
 * 类描述：普通java类获取 spring中的bean方法</br>
 * 创建人：fangjian </br>
 * 创建时间：2016年6月24日 下午4:25:00   </br>
 * 修改人：fangjian </br>
 * 修改时间：2016年6月24日 下午4:25:00   </br>
 * 修改备注：   </br>
 * @version    </br>
 */
public class ApplicationUtil implements ApplicationContextAware{
    private static ApplicationContext applicationContext;  
    
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationUtil.applicationContext = applicationContext;
    }
    
    public static Object getBean(String name){
        return applicationContext.getBean(name);
    }
}

