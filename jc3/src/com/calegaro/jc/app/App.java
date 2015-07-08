package com.calegaro.jc.app;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import com.calegaro.jc.domain.User;
import com.calegaro.jc.domain.UserSignup;
import com.calegaro.jc.service.SomeService;
import com.calegaro.jc.service.UserService;

@Component
public class App {

	@Autowired
	private SomeService myService;

	@Autowired
	private UserService userService;

	private Scanner scanner = null;

	public void run() {
		this.scanner = new Scanner(System.in);
		menuPrincipal();
	}

	private void menuPrincipal() {
		System.out.println("0 - exit");
		System.out.println("1 - List users");
		System.out.println("2 - New user");
		System.out.println("3 - List names");
		System.out.println("4 - Get name and pwd");
		String c = scanner.nextLine();
		switch (c) {
		case "0":
			scanner.close();
			return;
		case "1":
			listUsers();
			break;
		case "2":
			newUser();
			break;
		case "3":
			listNames();
			break;
		case "4":
			getNameAndPwd();
			break;
		default:
			break;
		}
		menuPrincipal();
	}

	private void getNameAndPwd() {
		System.out.println("Name:");
		String name = scanner.nextLine();
		User user = userService.getNameAndPwd(name);
		String pwd = user.getPwd();
		System.out.println("Pwd: ".concat(pwd == null ? "" : pwd));
	}

	private void listNames() {
		PageRequest pageRequest = new PageRequest(0, 2);
		List<String> users = userService.getNames(pageRequest);
		for (String user : users) {
			System.out.println(user);
		}
	}

	private void newUser() {
		System.out.println("Name:");
		String name = scanner.nextLine();
		System.out.println("Confirm Name:");
		String confirmName = scanner.nextLine();
		System.out.println("Password:");
		String password = scanner.nextLine();
		System.out.println("Confirm Password:");
		String confirmPwd = scanner.nextLine();
		UserSignup userSignup = new UserSignup();
		User user = new User();
		user.setName(name);
		user.setPwd(password);
		userSignup.setUser(user);
		userSignup.setConfirmName(confirmName);
		userSignup.setConfirmPwd(confirmPwd);
		if (userService.createUser(userSignup) != null) {
			System.out.println("User ".concat(name).concat(" created."));
		} else {
			System.out.println("name or password doesn't match.");
		}
	}

	private void listUsers() {
		PageRequest pageRequest = new PageRequest(0, 2);
		Sort sort = new Sort(Direction.ASC, "name");
		List<User> users = userService.getUsers(pageRequest, sort);
		for (User user : users) {
			System.out.println(user.getName());
		}
	}

}