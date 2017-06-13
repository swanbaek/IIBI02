package com.example;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class HelloController {

	@RequestMapping("/hello")
	public String test(Model m){
		System.out.println("들어옴");
		return "hello";
	}
	@RequestMapping("/hi")
	public Map<String, String> test2(){
		Map map=new HashMap();
		map.put("name","홍길동");
		map.put("age", "22");
		return map;
	}
}
