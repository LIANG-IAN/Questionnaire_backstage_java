package com.example.questionnaire_backstage.vo;

import com.example.questionnaire_backstage.entity.AnswerRecord;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AnswerRecordRequest {

  @JsonProperty("id")
  private int id;

  @JsonProperty("questionnaireId")
  private int questionnaireId;

  @JsonProperty("userId")
  private int userId;

  private AnswerRecord answerRecord;


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

  public AnswerRecord getAnswerRecord() {
    return answerRecord;
  }
}
