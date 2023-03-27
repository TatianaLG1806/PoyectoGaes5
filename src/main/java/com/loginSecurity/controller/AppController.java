package com.loginSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

	@GetMapping("/login")
	public String index() {
		return "index";
	}
	@GetMapping({"/"})
	public String pagina() {
		return "pagina";
	}
	
	@GetMapping("/menu")
	public String menu() {
		return "menu";
	}
	
	@GetMapping("/user")
	public String user() {
		return "user";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
	@GetMapping("/menu/logout")
	public String pg() {
		return "pagina";
	}
}
