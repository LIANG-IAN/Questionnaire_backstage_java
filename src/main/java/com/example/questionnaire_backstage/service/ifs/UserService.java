package com.example.questionnaire_backstage.service.ifs;

import com.example.questionnaire_backstage.vo.UserRequest;
import com.example.questionnaire_backstage.vo.UserResponse;

public interface UserService {

  // 新增人
  // 電話號碼不得重複
  public UserResponse addUser(UserRequest userRequest);

  // 刪除人
  public UserResponse deleteUser(UserRequest userRequest);

  // Id搜尋人
  public UserResponse findByUserId(UserRequest userRequest);

}
