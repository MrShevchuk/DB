package com.example.test2;

import com.example.test2.model.User;
import com.example.test2.service.UserService;
import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class Test2Application {
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(Test2Application.class, args);
	}

//	@EventListener(ApplicationReadyEvent.class)
//
//
//	public void onStart() {
//		User user = userService.saveNewUser("efwgwegw", "ewfwfwef", "dwfefwe");
//		User userFromDB = userService.getUserEmeil("wfwefw");
//		System.out.println();
//	}
}
