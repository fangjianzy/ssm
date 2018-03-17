package com.fangjian.framework.core.ehcache;
/**   
 * 类名称：EhCacheTestService   </br>
 * 类描述：   </br>
 * 创建人：fangjian </br>
 * 创建时间：2016年6月30日 下午1:51:29   </br>
 * 修改人：fangjian </br>
 * 修改时间：2016年6月30日 下午1:51:29   </br>
 * 修改备注：   </br>
 * @version    </br>
 */
public interface EhCacheTestService {
	//根据key获取对象
	public Object getCacheElement(String cacheKey);
	//保存对象
	public void addToCache(String cacheKey, Object result);
	//清除缓存对象
	public void removeCache(String cacheKey);
}

