package com.example.questionnaire_backstage.repository;

import com.example.questionnaire_backstage.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {

}
