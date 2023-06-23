package com.example.questionnaire_backstage.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "questionnaire")
public class Questionnaire {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "questionnaire")
  private String questionnaire;

  @Column(name = "main_point")
  private String mainPoint;

  @Column(name = "starting_time")
  private LocalDate startingTime = LocalDate.now();

  @Column(name = "end_time")
  private LocalDate endTime;

  public Questionnaire() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getQuestionnaire() {
    return questionnaire;
  }

  public Questionnaire(int id, String questionnaire, String mainPoint, LocalDate startingTime, LocalDate endTime) {
    this.id = id;
    this.questionnaire = questionnaire;
    this.mainPoint = mainPoint;
    this.startingTime = startingTime;
    this.endTime = endTime;
  }

  public void setQuestionnaire(String questionnaire) {
    this.questionnaire = questionnaire;
  }

  public String getMainPoint() {
    return mainPoint;
  }

  public void setMainPoint(String mainPoint) {
    this.mainPoint = mainPoint;
  }

  public LocalDate getStartingTime() {
    return startingTime;
  }

  public void setStartingTime(LocalDate startingTime) {
    this.startingTime = startingTime;
  }

  public LocalDate getEndTime() {
    return endTime;
  }

  public void setEndTime(LocalDate endTime) {
    this.endTime = endTime;
  }
}
