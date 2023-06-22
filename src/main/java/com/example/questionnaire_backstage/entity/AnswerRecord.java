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
}
