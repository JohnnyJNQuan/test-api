package com.todoservice.gemfirerestapi.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.gemfire.CacheFactoryBean;
import org.springframework.data.gemfire.LocalRegionFactoryBean;

import com.gemstone.gemfire.cache.GemFireCache;
import com.todoservice.gemfirerestapi.model.ToDoItem;

@Configuration
public class GemfireConfig {
	@Bean
	Properties gemfireProperties() {
		Properties gemfireProperties = new Properties();
		gemfireProperties.setProperty("name", "EmbeddedGemfireApplication");
		gemfireProperties.setProperty("mcast-port", "0");
		return gemfireProperties;
	}

	@Bean
	CacheFactoryBean gemfireCache() {
		CacheFactoryBean gemfireCache = new CacheFactoryBean();
		gemfireCache.setProperties(gemfireProperties());
		return gemfireCache;
	}

	@Bean
	LocalRegionFactoryBean<String, ToDoItem> toDoItemRegion(final GemFireCache cache) {
		LocalRegionFactoryBean<String, ToDoItem> todoitemRegion = new LocalRegionFactoryBean<>();
		todoitemRegion.setCache(cache);
		todoitemRegion.setName("todoitem");
		todoitemRegion.setPersistent(false);
		return todoitemRegion;
	}
}