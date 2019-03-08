package com.fisher.cache.support;

import com.fisher.cache.CacheRedisCaffeineProperties;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Collection;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;


public class RedisCaffeineCacheManager implements CacheManager {
	
	private final Logger logger = LoggerFactory.getLogger(RedisCaffeineCacheManager.class);
	
	private ConcurrentMap<String, Cache> cacheMap = new ConcurrentHashMap<String, Cache>();
	
	private CacheRedisCaffeineProperties cacheRedisCaffeineProperties;
	
	private RedisTemplate<Object, Object> stringKeyRedisTemplate;

	private boolean dynamic = true;

	private Set<String> cacheNames;

	public RedisCaffeineCacheManager(CacheRedisCaffeineProperties cacheRedisCaffeineProperties,
                                     RedisTemplate<Object, Object> stringKeyRedisTemplate) {
		super();
		this.cacheRedisCaffeineProperties = cacheRedisCaffeineProperties;
		this.stringKeyRedisTemplate = stringKeyRedisTemplate;
		this.dynamic = cacheRedisCaffeineProperties.isDynamic();
		this.cacheNames = cacheRedisCaffeineProperties.getCacheNames();
	}

	@Override
	public Cache getCache(String name) {
		Cache cache = cacheMap.get(name);
		if(cache != null) {
			return cache;
		}
		if(!dynamic && !cacheNames.contains(name)) {
			return cache;
		}
		
		cache = new RedisCaffeineCache(name, stringKeyRedisTemplate, caffeineCache(), cacheRedisCaffeineProperties);
		Cache oldCache = cacheMap.putIfAbsent(name, cache);
		logger.debug("create cache instance, the cache name is : {}", name);
		return oldCache == null ? cache : oldCache;
	}
	
	public com.github.benmanes.caffeine.cache.Cache<Object, Object> caffeineCache(){
		Caffeine<Object, Object> cacheBuilder = Caffeine.newBuilder();
		if(cacheRedisCaffeineProperties.getCaffeine().getExpireAfterAccess() > 0) {
			cacheBuilder.expireAfterAccess(cacheRedisCaffeineProperties.getCaffeine().getExpireAfterAccess(), TimeUnit.MILLISECONDS);
		}
		if(cacheRedisCaffeineProperties.getCaffeine().getExpireAfterWrite() > 0) {
			cacheBuilder.expireAfterWrite(cacheRedisCaffeineProperties.getCaffeine().getExpireAfterWrite(), TimeUnit.MILLISECONDS);
		}
		if(cacheRedisCaffeineProperties.getCaffeine().getInitialCapacity() > 0) {
			cacheBuilder.initialCapacity(cacheRedisCaffeineProperties.getCaffeine().getInitialCapacity());
		}
		if(cacheRedisCaffeineProperties.getCaffeine().getMaximumSize() > 0) {
			cacheBuilder.maximumSize(cacheRedisCaffeineProperties.getCaffeine().getMaximumSize());
		}
		if(cacheRedisCaffeineProperties.getCaffeine().getRefreshAfterWrite() > 0) {
			cacheBuilder.refreshAfterWrite(cacheRedisCaffeineProperties.getCaffeine().getRefreshAfterWrite(), TimeUnit.MILLISECONDS);
		}
		return cacheBuilder.build();
	}

	@Override
	public Collection<String> getCacheNames() {
		return this.cacheNames;
	}
	
	public void clearLocal(String cacheName, Object key) {
		Cache cache = cacheMap.get(cacheName);
		if(cache == null) {
			return ;
		}
		
		RedisCaffeineCache redisCaffeineCache = (RedisCaffeineCache) cache;
		redisCaffeineCache.clearLocal(key);
	}
}
