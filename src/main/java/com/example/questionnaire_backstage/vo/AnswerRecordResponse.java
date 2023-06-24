package com.example.questionnaire_backstage.vo;

import com.example.questionnaire_backstage.entity.AnswerRecord;

import java.util.List;

public class AnswerRecordResponse {

  private AnswerRecord answerRecord;

  private List<AnswerRecord> answerRecordList;

  private String message;

  public AnswerRecord getAnswerRecord() {
    return answerRecord;
  }

  public List<AnswerRecord> getAnswerRecordList() {
    return answerRecordList;
  }

  public String getMessage() {
    return message;
  }
}
