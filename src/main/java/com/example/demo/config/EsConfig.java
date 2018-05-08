package com.example.demo.config;

import java.net.InetAddress;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Setting;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class EsConfig {

	@SuppressWarnings("resource")
	@Bean
	public TransportClient client() throws Exception{
		// 세팅 정보 
//		Settings settings = Settings.builder()
//                .put("cluster.name", clusterName).build();
//		
		// 클라이언트 생성
		return new PreBuiltTransportClient(Settings.EMPTY)
		        .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
		
	}

}
