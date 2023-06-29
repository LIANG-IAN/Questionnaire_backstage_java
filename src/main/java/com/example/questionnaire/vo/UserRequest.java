package com.example.questionnaire.vo;

import com.example.questionnaire.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRequest {

  @JsonProperty("id")
  private int id;

  @JsonProperty("user")
  private User user;

  public int getId() {
    return id;
  }

  public User getUser() {
    return user;
  }
}
