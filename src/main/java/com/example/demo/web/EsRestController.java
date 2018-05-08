//package com.example.demo.web;
//
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.elasticsearch.action.get.GetResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.demo.repository.EsRepository;
//
//@RestController
//@RequestMapping("/es")
//public class EsRestController {
//	
//	@Autowired
//	EsRepository esRepo;
//	
//	@RequestMapping("/get/{index}/{type}/{id}")
//	public Map<String, Object> get(HttpServletRequest request,
//			@PathVariable String index,
//			@PathVariable String type,
//			@PathVariable String id) {
//		return esRepo.getResponse(index, type, id);
//	}
//	
//}
