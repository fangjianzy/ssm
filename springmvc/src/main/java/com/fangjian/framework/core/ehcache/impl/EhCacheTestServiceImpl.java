package com.fangjian.framework.core.ehcache.impl;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.fangjian.framework.core.ehcache.EhCacheTestService;

/**   
 * 类名称：EhCacheTestServiceImpl   </br>
 * 类描述：   </br>
 * 创建人：fangjian </br>
 * 创建时间：2016年6月30日 下午1:52:07   </br>
 * 修改人：fangjian </br>
 * 修改时间：2016年6月30日 下午1:52:07   </br>
 * 修改备注：   </br>
 * @version    </br>
 */
@Service("ehCacheTestService")
public class EhCacheTestServiceImpl implements EhCacheTestService {
	
	/**
	 * 
	* value 制定ehcache的配置文件中的名字
	* <p>Title: getCacheElement</p> 
	* <p>Description: </p> 
	* @param cacheKey
	* @return 
	* @see com.fangjian.framework.core.ehcache.EhCacheTestService#getCacheElement(java.lang.String)
	 */
	@Override
	@Cacheable(value="serviceCache",key="#cacheKey")
	public Object getCacheElement(String cacheKey) {
		
		return null;
	}
	
	/**
	 * 
	* value 制定ehcache的配置文件中的名字
	* <p>Title: getCacheElement</p> 
	* <p>Description: </p> 
	* @param cacheKey
	* @return 
	* @see com.fangjian.framework.core.ehcache.EhCacheTestService#getCacheElement(java.lang.String)
	 */
	@Override
	@CachePut(value="serviceCache",key="#cacheKey")
	public void addToCache(String cacheKey, Object result) {
		System.out.println("add cache key");
	}
	
	//制定元素的清理，而不是全部清理，true表示全部清理
	@Override
	@CacheEvict(value="serviceCache", allEntries=false,key="#cacheKey")
	public void removeCache(String cacheKey) {
		System.out.println("delete cache by  keyid ");
	}

	

}

