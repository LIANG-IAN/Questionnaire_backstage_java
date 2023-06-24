package com.example.questionnaire_backstage.vo;

import com.example.questionnaire_backstage.entity.AnswerContent;

import java.util.List;

public class AnswerContentResponse {

  private AnswerContent answerContent;

  private List<AnswerContent> answerContentList;

  private String message;

  public AnswerContentResponse() {
  }

  public AnswerContentResponse(AnswerContent answerContent, String message) {
    this.answerContent = answerContent;
    this.message = message;
  }

  public AnswerContentResponse(List<AnswerContent> answerContentList, String message) {
    this.answerContentList = answerContentList;
    this.message = message;
  }

  public AnswerContentResponse(String message) {
    this.message = message;
  }

  public AnswerContent getAnswerContent() {
    return answerContent;
  }

  public List<AnswerContent> getAnswerContentList() {
    return answerContentList;
  }

  public String getMessage() {
    return message;
  }
}
