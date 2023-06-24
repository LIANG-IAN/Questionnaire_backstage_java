package com.example.questionnaire_backstage.vo;

import com.example.questionnaire_backstage.entity.User;

public class UserResponse {

  private User user;

  private String message;

  public UserResponse() {
  }

  public UserResponse(User user, String message) {
    this.user = user;
    this.message = message;
  }

  public UserResponse(String message) {
    this.message = message;
  }

  public User getUser() {
    return user;
  }

  public String getMessage() {
    return message;
  }
}
