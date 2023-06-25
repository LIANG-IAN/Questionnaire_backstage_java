package com.example.questionnaire.repository;

import com.example.questionnaire.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {

  public User findByTel(String tel);
}
