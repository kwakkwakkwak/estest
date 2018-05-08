package com.example.demo;




import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

import org.elasticsearch.search.SearchHit;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.repository.EsRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DemoApplicationTests {
	
	@Autowired
	EsRepository esRepository;

	@Test
	public void test01_getResponse() {
		System.out.println( esRepository.getResponse("twitter","view","1"));
		System.out.println( esRepository.getResponse("twitter","view","2"));
		System.out.println( esRepository.getResponse("twitter","view","3"));
	}
	
	@Test
	public void test03_deleteResponse() {
		System.out.println(esRepository.deleteResponse("twitter", "view", "1"));
	}
	@Test
	public void test02_indexResponse() throws IOException {
		System.out.println(esRepository.indexResponse("twitter", "view", "1"));

	}
	@Test
	public void test04_update() throws IOException, InterruptedException, ExecutionException {
		System.out.println( esRepository.update());
	}
	@Test
	public void test05() {
		HashMap<String, Object> result = esRepository.findSongWithPrefix("ki");


		SearchHit [] hits = (SearchHit [])result.get("contentsList");
		System.out.println("Total : " + result.get("total"));
		System.out.println("user : " + hits[0].getSource().get("user"));
	}

	
	
}
