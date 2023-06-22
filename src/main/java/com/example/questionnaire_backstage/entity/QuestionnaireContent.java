package com.example.questionnaire_backstage.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "questionnaire_content")
public class QuestionnaireContent {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "question")
  private String question;

  @Column(name = "options")
  private String options;

  @Column(name = "is_necessary", columnDefinition = "TINYINT(1)")
  private boolean isNecessary;

  @Column(name = "type")
  private String type;

  @ManyToOne
  @JoinColumn(name = "questionnaire_id")
  private Questionnaire questionnaire;

  public QuestionnaireContent() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  public String getOptions() {
    return options;
  }

  public void setOptions(String options) {
    this.options = options;
  }

  public boolean isNecessary() {
    return isNecessary;
  }

  public void setNecessary(boolean necessary) {
    isNecessary = necessary;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Questionnaire getQuestionnaire() {
    return questionnaire;
  }

  public void setQuestionnaire(Questionnaire questionnaire) {
    this.questionnaire = questionnaire;
  }
}
