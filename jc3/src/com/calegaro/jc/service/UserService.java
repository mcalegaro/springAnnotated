package com.calegaro.jc.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.calegaro.jc.domain.User;
import com.calegaro.jc.domain.UserSignup;

public interface UserService {
	List<User> getUsers(Pageable pageable, Sort sort);

	List<String> getNames(Pageable pageable);

	User getNameAndPwd(String name);

	User findByName(String username);

	User createUser(UserSignup userSignup);
}
