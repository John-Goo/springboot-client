package com.pactera.springboot.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;

public class RestTmeplateClient {


	public static RestTmeplateClient build() {
		return new RestTmeplateClient();
	}

	
	public <T> T target(Class<T> apiType, String url) {
		Gson builderTime = (new GsonBuilder()).setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		return Feign.builder()
				.encoder(new GsonEncoder(builderTime))
				.decoder(new GsonDecoder(builderTime))
				.target(apiType, url);
	}
}
