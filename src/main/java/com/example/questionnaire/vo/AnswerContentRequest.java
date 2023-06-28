package com.example.questionnaire.vo;

import com.example.questionnaire.entity.AnswerContent;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AnswerContentRequest {

  @JsonProperty("id")
  private int id;

  @JsonProperty("questionnaireId")
  private int questionnaireId;

  @JsonProperty("answerContent")
  private AnswerContent answerContent;

  @JsonProperty("answerContentList")
  private List<AnswerContent> answerContentList;

  public int getId() {
    return id;
  }

  public int getQuestionnaireId() {
    return questionnaireId;
  }

  public AnswerContent getAnswerContent() {
    return answerContent;
  }

  public List<AnswerContent> getAnswerContentList() {
    return answerContentList;
  }
}
