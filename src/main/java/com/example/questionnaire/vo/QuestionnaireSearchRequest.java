package com.example.questionnaire.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class QuestionnaireSearchRequest {

  @JsonProperty("startingTime")
  private LocalDate startingTime;

  @JsonProperty("endTime")
  private LocalDate endTime;

  @JsonProperty("questionnaire")
  private String questionnaire;

  public LocalDate getStartingTime() {
    return startingTime;
  }

  public LocalDate getEndTime() {
    return endTime;
  }

  public String getQuestionnaire() {
    return questionnaire;
  }

  public void setQuestionnaire(String questionnaire) {
    this.questionnaire = questionnaire;
  }
}
