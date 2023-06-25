package com.example.questionnaire.service.impl;

import com.example.questionnaire.constants.RtnCode;
import com.example.questionnaire.entity.User;
import com.example.questionnaire.repository.UserDao;
import com.example.questionnaire.service.ifs.UserService;
import com.example.questionnaire.vo.UserRequest;
import com.example.questionnaire.vo.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
public class UserImpl implements UserService {

  @Autowired
  UserDao userDao;

  @Override
  public UserResponse addUser(UserRequest userRequest) {
    User user = userRequest.getUser();

    // 判斷User資料是否符合規定
    if (isUserLegal(user)) {
      return new UserResponse(RtnCode.INCORRECT_INFO_ERROR.getMessage());
    }

    // 依據電話號碼，判斷是否登入過
    User oldUser = userDao.findByTel(user.getTel());
    if (oldUser != null){
      oldUser.setName(user.getName());
      oldUser.setAge(user.getAge());
      oldUser.setEmail(user.getEmail());

      userDao.save(oldUser);

      return new UserResponse(oldUser.getId(),RtnCode.ADD_SUCCESS.getMessage());
    }
    User newUser = userDao.save(user);
    return new UserResponse(newUser.getId(),RtnCode.ADD_SUCCESS.getMessage());
  }

  @Override
  public UserResponse deleteUser(UserRequest userRequest) {
    int id = userRequest.getId();

    // 判斷Id是否符合規定
    if (id <=0){
      return new UserResponse(RtnCode.INCORRECT_INFO_ERROR.getMessage());
    }

    userDao.deleteById(id);

    return new UserResponse(RtnCode.DELETE_SUCCESS.getMessage());
  }

  @Override
  public UserResponse findByUserId(UserRequest userRequest) {
    int id = userRequest.getId();

    // 判斷Id是否符合規定
    if (id <=0){
      return new UserResponse(RtnCode.INCORRECT_INFO_ERROR.getMessage());
    }

    Optional<User> temp = userDao.findById(userRequest.getId());

    // 判斷人是否存在
    if (temp.isEmpty()){
      return new UserResponse(RtnCode.NOT_FOUND.getMessage());
    }

    User user = temp.get();

    return new UserResponse(user,RtnCode.FIND_SUCCESS.getMessage());
  }


  // 檢查物件User，不合規定返回true
  private boolean isUserLegal(User user){
    return !StringUtils.hasText(user.getName()) ||
            user.getAge() < 0 ||
            !StringUtils.hasText(user.getTel()) ||
            !StringUtils.hasText(user.getEmail());
  }
}
