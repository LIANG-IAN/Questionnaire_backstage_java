package com.example.questionnaire_backstage.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "answer_content")
public class AnswerContent {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "user_id")
  private int userId;

  @Column(name = "answer")
  private int answer;

  @ManyToOne
  @JoinColumn(name = "questionnaire_id")
  private Questionnaire questionnaire;

  @ManyToOne
  @JoinColumn(name = "questionnaire_content_id")
  private QuestionnaireContent questionnaireContent;

  public AnswerContent() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public int getAnswer() {
    return answer;
  }

  public void setAnswer(int answer) {
    this.answer = answer;
  }

  public Questionnaire getQuestionnaire() {
    return questionnaire;
  }

  public void setQuestionnaire(Questionnaire questionnaire) {
    this.questionnaire = questionnaire;
  }

  public QuestionnaireContent getQuestionnaireContent() {
    return questionnaireContent;
  }

  public void setQuestionnaireContent(QuestionnaireContent questionnaireContent) {
    this.questionnaireContent = questionnaireContent;
  }
}
