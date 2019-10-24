package com.pactera.springboot.example;

import com.google.gson.Gson;
import com.pactera.springboot.client.RestTemplateClient;

public class CallClientDemo {

	
	// URL
	public static final String URL = "http://localhost:8080";
	
	public static void main(String[] args) {

		HelloClient helloClient =  RestTemplateClient
				.build()
				.target(HelloClient.class, URL);
		
		while(true) {
			try {
				Person person = helloClient.getPerson(100);
				Gson gjson = new Gson();
				String strJson = gjson.toJson(person);
				System.out.println("客户端接收到数据："+strJson);
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	
		
	}

}
