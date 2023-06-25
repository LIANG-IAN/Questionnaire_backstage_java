package com.example.questionnaire.repository;

import com.example.questionnaire.entity.AnswerRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRecordDao extends JpaRepository<AnswerRecord, Integer> {

  @Query(value = "select * from answer_record where user_id = :userId and questionnaire_id = :questionnaireId", nativeQuery = true)
  public AnswerRecord findByUserIdAndQuestionnaireId(
          @Param("userId") int userId,
          @Param("questionnaireId") int questionnaireId
  );

  @Query(value = "select * from answer_record where user_id = :userId order by filling_time DESC ", nativeQuery = true)
  public List<AnswerRecord> findAllByQuestionnaireIdFromAnswerRecordOrder(
          @Param("userId") int userID
  );

}
