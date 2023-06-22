package com.example.questionnaire_backstage;

import com.example.questionnaire_backstage.entity.Questionnaire;
import com.example.questionnaire_backstage.service.ifs.QuestionnaireService;
import com.example.questionnaire_backstage.vo.QuestionnaireRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class QuestionnaireTest {

  @Autowired
  QuestionnaireService questionnaireService;

  @Test
  public void addQuestionnaire() {
    LocalDateTime startingTime = LocalDateTime.of(2020, 6, 29, 14, 0, 0);
    LocalDateTime endTime = LocalDateTime.of(2021, 6, 29, 14, 0, 0);
    Questionnaire questionnaire = new Questionnaire(0, "問卷1", "你為什麼來填本問卷", startingTime, endTime);
    QuestionnaireRequest questionnaireRequest = new QuestionnaireRequest();
    questionnaireRequest.setQuestionnaire(questionnaire);
    System.out.println(questionnaireRequest.getQuestionnaire().getQuestionnaire());
    questionnaireService.addQuestionnaire(questionnaireRequest);
  }

  @Test
  public void deleteQuestionnaire() {
    int id = 9;
    QuestionnaireRequest questionnaireRequest = new QuestionnaireRequest();
    questionnaireRequest.setId(id);
    System.out.println(questionnaireRequest.getId());
    questionnaireService.deleteQuestionnaire(questionnaireRequest);
  }

}
