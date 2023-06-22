package com.example.questionnaire_backstage.vo;

import com.example.questionnaire_backstage.entity.Questionnaire;

public class QuestionnaireResponse {

  private Questionnaire questionnaire;

  private String message;

  public QuestionnaireResponse() {
  }

  public QuestionnaireResponse(Questionnaire questionnaire, String message) {
    this.questionnaire = questionnaire;
    this.message = message;
  }

  public QuestionnaireResponse(String message) {
    this.message = message;
  }

  public Questionnaire getQuestionnaire() {
    return questionnaire;
  }

  public String getMessage() {
    return message;
  }
}
