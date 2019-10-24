package com.pactera.springboot.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;

/**
 * @ClassName: RestTmeplateClient
 * @version 1.0
 * @Desc: 调用微服务client类
 * @author John Goo
 * @date 2019年10月23日上午9:40:13
 * @history v2.0
 */
public class RestTemplateClient {

	
	
	/**
	 * 不允许外界实例化
	 */
	private RestTemplateClient() {
	}
	
	/**
	 * 
	 * 描述：获取RestTemplateClient
	 * @author John Goo
	 * @date 2019年10月23日上午9:38:22
	 * @return
	 */
	public static RestTemplateClient build() {
		return new RestTemplateClient();
	}

	
	/**
	 * 
	 * 描述：装载接口代理
	 * @author John Goo
	 * @date 2019年10月23日上午9:39:07
	 * @param <T>
	 * @param apiType
	 * @param url
	 * @return
	 */
	public <T> T target(Class<T> apiType, String url) {
		Gson builderTime = (new GsonBuilder()).setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		return Feign.builder()
				.encoder(new GsonEncoder(builderTime))
				.decoder(new GsonDecoder(builderTime))
				.target(apiType, url);
	}
}
