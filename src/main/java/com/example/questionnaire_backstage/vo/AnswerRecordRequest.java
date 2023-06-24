package com.example.questionnaire_backstage.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AnswerRecordRequest {

  @JsonProperty("id")
  private int id;

  @JsonProperty("questionnaireId")
  private int questionnaireId;

  @JsonProperty("userId")
  private int userId;


  public AnswerRecordRequest() {
  }

  public int getId() {
    return id;
  }

  public int getQuestionnaireId() {
    return questionnaireId;
  }

  public int getUserId() {
    return userId;
  }
}
