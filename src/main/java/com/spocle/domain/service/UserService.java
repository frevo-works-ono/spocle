package com.spocle.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spocle.domain.model.entity.Member;
import com.spocle.domain.model.entity.User;
import com.spocle.domain.repository.MemberRepository;
import com.spocle.domain.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User findOne(String id) {
		return userRepository.findOne(id);
	}

	public User create(User user) {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	public User update(User user) {
		return userRepository.save(user);
	}

	public void delete(String id) {
		userRepository.delete(id);
	}
}
