//package com.example.demo.web;
//
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//
//import com.example.demo.vo.TwitterVO;
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
//	@RequestMapping("/get/{id}")
//	public Map<String, Object> get(HttpServletRequest request,
//                                   @PathVariable String id
//			) {
//	    TwitterVO vo = new TwitterVO();
//	    vo.setId(id);
//		return esRepo.get(vo);
//	}
//
//    @RequestMapping("/put/{vo}")
//    public Map<String, Object> put(HttpServletRequest request,
//                                   @PathVariable TwitterVO vo) {
//        return esRepo.get(vo);
//    }
//
//}
