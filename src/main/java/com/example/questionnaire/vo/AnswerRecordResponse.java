package com.example.questionnaire.vo;

import com.example.questionnaire.entity.AnswerRecord;

import java.util.List;

public class AnswerRecordResponse {

  private AnswerRecord answerRecord;

  private List<AnswerRecord> answerRecordList;

  private String message;

  public AnswerRecordResponse(AnswerRecord answerRecord, String message) {
    this.answerRecord = answerRecord;
    this.message = message;
  }

  public AnswerRecordResponse(List<AnswerRecord> answerRecordList, String message) {
    this.answerRecordList = answerRecordList;
    this.message = message;
  }

  public AnswerRecordResponse(String message) {
    this.message = message;
  }

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
