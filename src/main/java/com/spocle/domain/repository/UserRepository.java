package com.spocle.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spocle.domain.model.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
  public User findByMailAddress(String mailAddress);

  public User findByTempKey(String tempKey);
}
