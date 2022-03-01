package main.java.com.example.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewController {
	
	@GetMapping("/getDate")
	public Date getDate() {
		
		return new Date();
	}
	
}

