package com.example.questionnaire_backstage.vo;

import java.time.LocalDate;

public class QuestionnaireSearchRequest {

  private LocalDate startingTime;

  private LocalDate endTime;

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
