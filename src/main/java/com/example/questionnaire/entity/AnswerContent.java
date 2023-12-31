package com.example.questionnaire.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "answer_content")
public class AnswerContent {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @Column(name = "answer")
  private String answer;

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

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
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
