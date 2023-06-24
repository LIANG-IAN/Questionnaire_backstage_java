package com.example.questionnaire_backstage.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "answer_record")
public class AnswerRecord {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @ManyToOne
  @JoinColumn(name = "questionnaire_id")
  private Questionnaire questionnaire;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @Column(name = "filling_time")
  private LocalDateTime fillingTime = LocalDateTime.now();

  public AnswerRecord() {
  }

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

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public LocalDateTime getFillingTime() {
    return fillingTime;
  }

  public void setFillingTime(LocalDateTime fillingTime) {
    this.fillingTime = fillingTime;
  }
}
