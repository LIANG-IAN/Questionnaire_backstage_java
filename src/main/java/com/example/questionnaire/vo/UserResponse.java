package com.example.questionnaire.vo;

import com.example.questionnaire.entity.User;

public class UserResponse {

  private int id;

  private User user;

  private String message;

  public UserResponse() {
  }

  public UserResponse(int id, String message) {
    this.id = id;
    this.message = message;
  }

  public UserResponse(User user, String message) {
    this.user = user;
    this.message = message;
  }

  public UserResponse(String message) {
    this.message = message;
  }

  public int getId() {
    return id;
  }

  public User getUser() {
    return user;
  }

  public String getMessage() {
    return message;
  }
}
