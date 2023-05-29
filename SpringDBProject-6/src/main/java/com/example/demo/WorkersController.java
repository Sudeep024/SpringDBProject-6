package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class WorkersController {
	
	@Autowired
	WorkRepo repo;

	@RequestMapping("home")
	String home() {
		return "home.jsp";
	}

	@RequestMapping("Addwork")
	String Addwork(Workers w) {
		repo.save(w);
		return "get.jsp";
	}

	@RequestMapping("getwork")
	String GetId(HttpSession h, int id) {
		Workers w = repo.findById(id).orElse(null);
		h.setAttribute("name", w);
		return "get.jsp";
	}

}
