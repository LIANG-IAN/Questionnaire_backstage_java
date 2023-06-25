package com.example.questionnaire.vo;

import com.example.questionnaire.entity.AnswerContent;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AnswerContentRequest {

  @JsonProperty("id")
  private int id;

  @JsonProperty("questionnaireId")
  private int questionnaireId;

  @JsonProperty("answerContent")
  private AnswerContent answerContent;

  public int getId() {
    return id;
  }

  public int getQuestionnaireId() {
    return questionnaireId;
  }

  public AnswerContent getAnswerContent() {
    return answerContent;
  }
}
