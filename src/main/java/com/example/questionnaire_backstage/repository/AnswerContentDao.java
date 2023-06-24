package com.example.questionnaire_backstage.repository;

import com.example.questionnaire_backstage.entity.AnswerContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerContentDao extends JpaRepository<AnswerContent, Integer> {

  @Query(value = "select * from answer_content where questionnaire_id = :questionnaireId", nativeQuery = true)
  public List<AnswerContent> findByQuestionnaireId(@Param("questionnaireId") int questionnaireId);

  @Query(value = "select * from answer_content where user_id = :userId " +
          "and questionnaire_id = :questionnaireId " +
          "and questionnaire_content_id = :questionnaireContentId", nativeQuery = true)
  public AnswerContent findByUserIdAndQuestionnaireIdAndQuestionnaireContentId(
          @Param("userId") int userId,
          @Param("questionnaireId") int questionnaireId,
          @Param("questionnaireContentId") int questionnaireContentId
  );
}
