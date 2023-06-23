package com.example.questionnaire_backstage.repository;

import com.example.questionnaire_backstage.entity.QuestionnaireContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionnaireContentDao extends JpaRepository<QuestionnaireContent,Integer> {

  @Query(value="SELECT * FROM questionnaire_content  WHERE questionnaire_id = :questionnaireId",nativeQuery = true)
  public List<QuestionnaireContent> findAllByQuestionnaireId(@Param("questionnaireId") int questionnaireId);
}
