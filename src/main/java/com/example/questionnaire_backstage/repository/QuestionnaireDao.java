package com.example.questionnaire_backstage.repository;

import com.example.questionnaire_backstage.entity.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface QuestionnaireDao extends JpaRepository<Questionnaire,Integer> {

  // 模糊搜尋
  // TODO
  // 用循環+Set集合，實現真模糊搜尋
  @Query(value = "select * from questionnaire where questionnaire regexp :questionnaire",nativeQuery = true)
  public List<Questionnaire> findByQuestionnaireFuzzySearch(@Param("questionnaire")String questionnaire);

  // 開始時間搜尋
  public List<Questionnaire> findByStartingTime(LocalDate startingTime);

  // 結束時間搜尋
  public List<Questionnaire> findByEndTime(LocalDate endTime);

  // 時間區間搜尋
  public List<Questionnaire> findByStartingTimeGreaterThanEqualAndEndTimeLessThanEqual(LocalDate startingTime, LocalDate endTime);

  // 開始時間以後搜尋
  public List<Questionnaire> findByStartingTimeGreaterThanEqual(LocalDate startingTime);

  // 結束時間以前搜尋
  public List<Questionnaire> findByEndTimeLessThanEqual(LocalDate endTime);
}
	
