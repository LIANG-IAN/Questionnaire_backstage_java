package com.example.questionnaire.vo;

import com.example.questionnaire.entity.Questionnaire;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class QuestionnaireRequest {

  @JsonProperty("id")
  private int id;

  @JsonProperty("idList")
  private List<Integer> idList;

  @JsonProperty("questionnaire")
  private Questionnaire questionnaire;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public List<Integer> getIdList() {
    return idList;
  }

  public Questionnaire getQuestionnaire() {
    return questionnaire;
  }

  public void setQuestionnaire(Questionnaire questionnaire) {
    this.questionnaire = questionnaire;
  }
}
