package com.example.questionnaire_backstage.repository;

import com.example.questionnaire_backstage.entity.AnswerRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRecordDao extends JpaRepository<AnswerRecord,Integer>{

}
