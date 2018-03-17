package com.fangjian.framework.core.ehcache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**   
 * 类名称：EHCacheUtil   </br>
 * 类描述：微信缓存工具类   </br>
 * 创建人：fangjian </br>
 * 创建时间：2016年1月21日 上午9:18:13   </br>
 * 修改人：fangjian </br>
 * 修改时间：2016年1月21日 上午9:18:13   </br>
 * 修改备注：   </br>
 * @version    </br>
 */
public class EHCacheUtil {

	private static final CacheManager cacheManager = new CacheManager();
	private Cache cache;
	
	//使用ehcache中wxCache作为缓存策略
	public EHCacheUtil(){
		this.cache=cacheManager.getCache("wxCache");
	}

	public Cache getCache() {
		return cache;
	}

	public void setCache(Cache cache) {
		this.cache = cache;
	}
        /*
	 * 通过名称从缓存中获取数据
	 */
	public Object getCacheElement(String cacheKey) throws Exception {
	        net.sf.ehcache.Element e = cache.get(cacheKey);
		if (e == null) {
			return null;
		}
		return e.getValue();
	}
	/*
	 * 将对象添加到缓存中
	 */
	public void addToCache(String cacheKey, Object result) throws Exception {
		Element element = new Element(cacheKey, result);
		cache.put(element);
	}

}

