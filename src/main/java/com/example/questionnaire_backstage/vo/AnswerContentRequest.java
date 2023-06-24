package com.example.questionnaire_backstage.vo;

import com.example.questionnaire_backstage.entity.AnswerContent;
import com.example.questionnaire_backstage.entity.Questionnaire;
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
