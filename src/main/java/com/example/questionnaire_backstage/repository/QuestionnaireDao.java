package com.example.questionnaire_backstage.repository;

import com.example.questionnaire_backstage.entity.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionnaireDao extends JpaRepository<Questionnaire,Integer> {

}
	
