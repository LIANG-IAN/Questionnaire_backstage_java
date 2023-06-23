package com.example.questionnaire_backstage.vo;

import com.example.questionnaire_backstage.entity.QuestionnaireContent;

import java.util.List;

public class QuestionnaireContentResponse {

  private QuestionnaireContent questionnaireContent;

  private List<QuestionnaireContent> questionnaireContentList;

  private String message;

  public QuestionnaireContentResponse() {
  }

  public QuestionnaireContentResponse(QuestionnaireContent questionnaireContent, String message) {
    this.questionnaireContent = questionnaireContent;
    this.message = message;
  }

  public QuestionnaireContentResponse(List<QuestionnaireContent> questionnaireContentList, String message) {
    this.questionnaireContentList = questionnaireContentList;
    this.message = message;
  }

  public QuestionnaireContentResponse(String message) {
    this.message = message;
  }

  public QuestionnaireContent getQuestionnaireContent() {
    return questionnaireContent;
  }

  public List<QuestionnaireContent> getQuestionnaireContentList() {
    return questionnaireContentList;
  }

  public String getMessage() {
    return message;
  }
}
