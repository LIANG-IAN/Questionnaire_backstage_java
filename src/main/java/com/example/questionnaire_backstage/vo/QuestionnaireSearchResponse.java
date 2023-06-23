package com.example.questionnaire_backstage.vo;

import com.example.questionnaire_backstage.entity.Questionnaire;

import java.util.List;

public class QuestionnaireSearchResponse {

  private List<Questionnaire> questionnaireList;

  private String message;

  public QuestionnaireSearchResponse() {
  }

  public QuestionnaireSearchResponse(String message) {
    this.message = message;
  }

  public QuestionnaireSearchResponse(List<Questionnaire> questionnaireList, String message) {
    this.questionnaireList = questionnaireList;
    this.message = message;
  }

  public List<Questionnaire> getQuestionnaireList() {
    return questionnaireList;
  }

  public String getMessage() {
    return message;
  }
}
