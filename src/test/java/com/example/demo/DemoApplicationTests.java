package com.example.demo;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

import com.example.demo.vo.TwitterVO;
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
	public void test01_get() {
		TwitterVO vo = new TwitterVO();
		vo.setId("1");
		System.out.println( esRepository.get(vo));
		vo.setId("1");
		System.out.println( esRepository.get(vo));
		vo.setId("1");
		System.out.println( esRepository.get(vo));
	}
	
	@Test
	public void test03_delete() {
		TwitterVO vo = new TwitterVO();
		vo.setId("6");
		System.out.println(esRepository.delete(vo));
	}

	@Test
	public void test02_index() throws IOException {
		TwitterVO twitterVO =  new TwitterVO();
		twitterVO.setId("6");
		System.out.println(esRepository.index(twitterVO));

	}
	@Test
	public void test04_update() throws IOException, InterruptedException, ExecutionException {
		TwitterVO twitterVO =  new TwitterVO();
		twitterVO.setId("3");
		twitterVO.setUser("kwak");
		twitterVO.setPostDate(new Date());
		twitterVO.setMessage("test");
		System.out.println( esRepository.update(twitterVO));
	}
	@Test
	public void test05() {
		TwitterVO twitterVO = new TwitterVO();
		HashMap<String, Object> result = esRepository.findPrefixTwitter(twitterVO,"ki");

		SearchHit [] hits = (SearchHit [])result.get("contentsList");
		System.out.println("Total : " + result.get("total"));
		System.out.println("user : " + hits[0].getSource().get("user"));
	}
	
}
