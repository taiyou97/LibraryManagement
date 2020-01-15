package com.app.controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.app.pojos.Users;
import com.app.pojos.UsersType;
import com.app.service.ICommonService;

@RestController // @Controller + @RespBody
@CrossOrigin//(origins="http://localhost:4200")
public class CommonController {

	@Autowired
	ICommonService service;
	
	@PostConstruct
	public void init() {
		System.out.println("CommonController init()" + service);
	}
	
	@PostMapping("/SignIn")
	public ResponseEntity<?> login(@RequestBody Users u, HttpSession hs){
		
		System.out.println("in process login form " + u.getEmail() + " " + u.getPasswd());
		try {
			u = service.login(u.getEmail(), u.getPasswd());
			hs.setAttribute("user_details", u);

			if (u.getRole().equals(UsersType.OWNER))
				return new ResponseEntity<>("OWNER", HttpStatus.OK);
			else if (u.getRole().equals(UsersType.LIBRARIAN))
				return new ResponseEntity<>("LIBRARIAN", HttpStatus.OK);
			return new ResponseEntity<>("USER", HttpStatus.OK);
		} catch (RuntimeException e) {
			String message = "Invalid Login, Please Retry";
			return new ResponseEntity<>(message, HttpStatus.NO_CONTENT);
		}
		
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody Users u){
		String message = "Users Not registered";
		try {
			return new ResponseEntity<>(service.registerUser(u), HttpStatus.OK);
		}catch (RuntimeException e) {
			return new ResponseEntity<>(message, HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
}
