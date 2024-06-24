package com.pratyush.project.personal.Cotrollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pratyush.project.personal.Beans.HelloWorldBean;

@RestController
public class HelloWorldController {

	//@RequestMapping (method = RequestMethod.GET , path = "/hello-world")
	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hello World!";
	}
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World Bean!");
	}
	
	@GetMapping(path = "/hello-world-bean/pathvar/{name}")
	public HelloWorldBean helloWorldPathVar(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World Bean!,%s",name));
	}
	
	
	
}
