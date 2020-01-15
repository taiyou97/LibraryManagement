package com.app.controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Users;
import com.app.pojos.UsersType;
import com.app.service.IOwnerService;

@RestController
@RequestMapping("/owner")
public class OwnerController {
	
	@Autowired
	IOwnerService service;
	
	@PostConstruct
	public void init() {
		System.out.println("OwnerController init()");
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> updateProfile(@RequestBody Users u, HttpSession hs) {
		try {
			Users logUser = (Users)hs.getAttribute("user_details");
			//if(u.getId() == logUser.getId())
				service.updateProfile(u);
			return new ResponseEntity<String>("Profile Updated", HttpStatus.ACCEPTED);
		}catch (RuntimeException e) {
			return new ResponseEntity<String>("Not Updated", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/subjectwise")
	public ResponseEntity<?> subjectWiseReport(HttpSession hs) {
		Users u = (Users) hs.getAttribute("user_details");
		if(u.getRole()!=UsersType.OWNER) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		try {
			service.updateProfile(u);
			return new ResponseEntity<String>("Profile Updated", HttpStatus.ACCEPTED);
		}catch (RuntimeException e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
