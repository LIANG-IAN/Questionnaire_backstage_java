package com.example.questionnaire.vo;

import com.example.questionnaire.entity.Questionnaire;

import java.util.List;

public class QuestionnaireResponse {

  private Questionnaire questionnaire;

  private List<Questionnaire> questionnaireList;

  private String message;

  public QuestionnaireResponse() {
  }

  public QuestionnaireResponse(Questionnaire questionnaire, String message) {
    this.questionnaire = questionnaire;
    this.message = message;
  }

  public QuestionnaireResponse(List<Questionnaire> questionnaireList, String message) {
    this.questionnaireList = questionnaireList;
    this.message = message;
  }

  public QuestionnaireResponse(String message) {
    this.message = message;
  }

  public Questionnaire getQuestionnaire() {
    return questionnaire;
  }

  public List<Questionnaire> getQuestionnaireList() {
    return questionnaireList;
  }

  public String getMessage() {
    return message;
  }
}
