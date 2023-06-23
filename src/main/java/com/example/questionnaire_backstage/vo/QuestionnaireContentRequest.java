package com.example.questionnaire_backstage.vo;

import com.example.questionnaire_backstage.entity.QuestionnaireContent;

import java.util.List;

public class QuestionnaireContentRequest {

  private int id;

  private List<Integer> idList;

  private int questionnaireId;

  private QuestionnaireContent questionnaireContent;

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
