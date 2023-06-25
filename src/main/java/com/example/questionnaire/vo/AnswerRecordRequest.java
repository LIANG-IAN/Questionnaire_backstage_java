package com.example.questionnaire.vo;

import com.example.questionnaire.entity.AnswerRecord;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AnswerRecordRequest {

  @JsonProperty("id")
  private int id;

  @JsonProperty("questionnaireId")
  private int questionnaireId;

  @JsonProperty("userId")
  private int userId;

  @JsonProperty("answerRecord")
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
