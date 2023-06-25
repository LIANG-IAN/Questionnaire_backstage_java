package com.example.questionnaire.constants;

public enum RtnCode {

  ADD_FAVORITE_SUCCESS("200", "新增收藏成功"),
  ADD_SUCCESS("200", "新增成功"),
  FIND_SUCCESS("200", "尋找成功"),
  MODIFY_SUCCESS("200", "修改成功"),
  DELETE_SUCCESS("200", "刪除成功"),
  NOT_ADD_INFO("400", "未新增任何資料"),
  NOT_DELETE_INFO("400", "未刪除任何資料"),
  NOT_MODIFY_INFO("400", "未更新任何資料"),
  NOT_FOUND("400", "此資料不存在"),
  INCORRECT_INFO_ERROR("400", "資料不正確");

  private final String code;

  private final String message;

  RtnCode(String code, String message) {
    this.code = code;
    this.message = message;
  }

  public String getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }
}