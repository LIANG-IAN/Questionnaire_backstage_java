package com.example.questionnaire_backstage.vo;

import com.example.questionnaire_backstage.entity.QuestionnaireContent;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class QuestionnaireContentRequest {

  @JsonProperty("id")
  private int id;

  @JsonProperty("idList")
  private List<Integer> idList;

  @JsonProperty("questionnaireId")
  private int questionnaireId;

  @JsonProperty("questionnaireContent")
  private QuestionnaireContent questionnaireContent;

  @JsonProperty("questionnaireContentList")
  private List<QuestionnaireContent> questionnaireContentList;

  public int getId() {
    return id;
  }

  public List<Integer> getIdList() {
    return idList;
  }

  public int getQuestionnaireId() {
    return questionnaireId;
  }

  public QuestionnaireContent getQuestionnaireContent() {
    return questionnaireContent;
  }

  public List<QuestionnaireContent> getQuestionnaireContentList() {
    return questionnaireContentList;
  }
}
