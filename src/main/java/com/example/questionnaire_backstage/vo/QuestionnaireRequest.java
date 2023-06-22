package com.example.questionnaire_backstage.vo;

import com.example.questionnaire_backstage.entity.Questionnaire;

public class QuestionnaireRequest {

  private int id;

  private Questionnaire questionnaire;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Questionnaire getQuestionnaire() {
    return questionnaire;
  }

  public void setQuestionnaire(Questionnaire questionnaire) {
    this.questionnaire = questionnaire;
  }
}
