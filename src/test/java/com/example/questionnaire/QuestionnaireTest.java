package com.example.questionnaire;

import com.example.questionnaire.entity.Questionnaire;
import com.example.questionnaire.service.ifs.QuestionnaireService;
import com.example.questionnaire.vo.QuestionnaireRequest;
import com.example.questionnaire.vo.QuestionnaireSearchRequest;
import com.example.questionnaire.vo.QuestionnaireResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;

@SpringBootTest
public class QuestionnaireTest {

  @Autowired
  QuestionnaireService questionnaireService;

  @Test
  public void addQuestionnaire() {
    LocalDate startingTime = LocalDate.of(2020, 6, 29);
    LocalDate endTime = LocalDate.of(2021, 6, 29);
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

  @Test
  public void findByQuestionnaireFuzzySearch(){
    QuestionnaireSearchRequest questionnaireSearchRequest = new QuestionnaireSearchRequest();
    questionnaireSearchRequest.setQuestionnaire("東");
    QuestionnaireResponse questionnaireResponse = questionnaireService.findByQuestionnaireFuzzySearch(questionnaireSearchRequest);
    System.out.println(CollectionUtils.isEmpty(questionnaireResponse.getQuestionnaireList()));
    System.out.println(questionnaireResponse.getQuestionnaireList().size());
    System.out.println("===================================================");
  }

}
