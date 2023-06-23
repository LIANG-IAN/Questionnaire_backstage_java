package com.example.questionnaire_backstage.service.impl;

import com.example.questionnaire_backstage.constants.RtnCode;
import com.example.questionnaire_backstage.entity.QuestionnaireContent;
import com.example.questionnaire_backstage.repository.QuestionnaireContentDao;
import com.example.questionnaire_backstage.repository.QuestionnaireDao;
import com.example.questionnaire_backstage.service.ifs.QuestionnaireContentService;
import com.example.questionnaire_backstage.vo.QuestionnaireContentRequest;
import com.example.questionnaire_backstage.vo.QuestionnaireContentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionnaireContentImpl implements QuestionnaireContentService {

  @Autowired
  QuestionnaireContentDao questionnaireContentDao;

  @Autowired
  QuestionnaireDao questionnaireDao;

  @Override
  public QuestionnaireContentResponse addQuestionnaireContent(QuestionnaireContentRequest questionnaireContentRequest) {
    List<QuestionnaireContent> questionnaireContentList = questionnaireContentRequest.getQuestionnaireContentList();

    // 非空判斷
    if (CollectionUtils.isEmpty(questionnaireContentList)) {
      return new QuestionnaireContentResponse(RtnCode.INCORRECT_INFO_ERROR.getMessage());
    }

    List<QuestionnaireContent> correctQuestionnaireContentList = new ArrayList<>();

    for (QuestionnaireContent questionnaireContent : questionnaireContentList) {

      // 判斷各參數是否符合規定，不符合則忽略
      if (isQuestionnaireContentLegal(questionnaireContent)) {
        continue;
      }

      // 選項標準化，移除所有空格
      String temp = questionnaireContent.getOptions().replace(" ","");
      questionnaireContent.setOptions(temp);

      correctQuestionnaireContentList.add(questionnaireContent);
    }

    // 判斷是否有合規定資料，沒有則跳出
    if(correctQuestionnaireContentList.size() == 0){
      return new QuestionnaireContentResponse(RtnCode.NOT_ADD_INFO.getMessage());
    }

    questionnaireContentDao.saveAll(correctQuestionnaireContentList);

    return new QuestionnaireContentResponse(RtnCode.ADD_QUESTIONNAIRE_CONTENT_SUCCESS.getMessage());
  }

  @Override
  public QuestionnaireContentResponse deleteQuestionnaireContent(QuestionnaireContentRequest questionnaireContentRequest) {
    List<Integer> idList = questionnaireContentRequest.getIdList();

    // 非空判斷
    if (CollectionUtils.isEmpty(idList)) {
      return new QuestionnaireContentResponse(RtnCode.INCORRECT_INFO_ERROR.getMessage());
    }

    List<Integer> correctIdList = new ArrayList<>();

    for (Integer id : idList) {

      // 判斷Id是否符合規定
      if (id <= 0){
        return new QuestionnaireContentResponse(RtnCode.INCORRECT_INFO_ERROR.getMessage());
      }

      // 判斷問卷問題是否存在，不存在則忽略
      if (!questionnaireContentDao.existsById(id)){
        continue;
      }

      correctIdList.add(id);
    }

    // 判斷是否有合規定資料，沒有則跳出
    if(correctIdList.size() == 0){
      return new QuestionnaireContentResponse(RtnCode.NOT_DELETE_INFO.getMessage());
    }

    questionnaireContentDao.deleteAllById(correctIdList);

    return new QuestionnaireContentResponse(RtnCode.DELETE_SUCCESS.getMessage());
  }

  @Override
  public QuestionnaireContentResponse modifyQuestionnaireContent(QuestionnaireContentRequest questionnaireContentRequest) {
    List<QuestionnaireContent> questionnaireContentList = questionnaireContentRequest.getQuestionnaireContentList();

    // 非空判斷
    if (CollectionUtils.isEmpty(questionnaireContentList)) {
      return new QuestionnaireContentResponse(RtnCode.INCORRECT_INFO_ERROR.getMessage());
    }
    List<QuestionnaireContent> correctQuestionnaireContentList = new ArrayList<>();

    for (QuestionnaireContent questionnaireContent : questionnaireContentList) {

      // 判斷各參數是否符合規定，不符合則忽略
      if (isQuestionnaireContentLegal(questionnaireContent)) {
        continue;
      }

      if (!questionnaireContentDao.existsById(questionnaireContent.getId())){
        continue;
      }

      // 選項標準化，移除所有空格
      String temp = questionnaireContent.getOptions().replace(" ","");
      questionnaireContent.setOptions(temp);


      correctQuestionnaireContentList.add(questionnaireContent);
    }

    // 判斷是否有合規定資料，沒有則跳出
    if(correctQuestionnaireContentList.size() == 0){
      return new QuestionnaireContentResponse(RtnCode.NOT_MODIFY_INFO.getMessage());
    }

    questionnaireContentDao.saveAll(correctQuestionnaireContentList);

    return new QuestionnaireContentResponse(RtnCode.MODIFY_SUCCESS.getMessage());
  }

  @Override
  public QuestionnaireContentResponse findAllByQuestionnaireId(QuestionnaireContentRequest questionnaireContentRequest) {
    int questionnaireId = questionnaireContentRequest.getQuestionnaireId();

    // 判斷Id是否符合規定
    if (questionnaireId <=0){
      return new QuestionnaireContentResponse(RtnCode.INCORRECT_INFO_ERROR.getMessage());
    }

    // 判斷問卷是否存在
    if(!questionnaireDao.existsById(questionnaireId)){
      return new QuestionnaireContentResponse(RtnCode.NOT_FOUND.getMessage());
    }

    List<QuestionnaireContent> questionnaireContentList = questionnaireContentDao.findAllByQuestionnaireId(questionnaireId);

    // 判斷是否有相符問卷題目
    if (CollectionUtils.isEmpty(questionnaireContentList)){
      return new QuestionnaireContentResponse(RtnCode.NOT_FOUND.getMessage());
    }

    return new QuestionnaireContentResponse(questionnaireContentList,RtnCode.FIND_SUCCESS.getMessage());
  }

  @Override
  public QuestionnaireContentResponse findById(QuestionnaireContentRequest questionnaireContentRequest) {
    int id = questionnaireContentRequest.getId();

    // 判斷Id是否符合規定
    if (id <=0){
      return new QuestionnaireContentResponse(RtnCode.INCORRECT_INFO_ERROR.getMessage());
    }

    // 判斷問卷題目是否存在
    Optional<QuestionnaireContent> temp = questionnaireContentDao.findById(id);
    if (temp.isEmpty()){
      return new QuestionnaireContentResponse(RtnCode.NOT_FOUND.getMessage());
    }

    QuestionnaireContent questionnaireContent = temp.get();

    return new QuestionnaireContentResponse(questionnaireContent,RtnCode.FIND_SUCCESS.getMessage());
  }


  // 檢查物件QuestionnaireContent，不合規定返回true
  private boolean isQuestionnaireContentLegal(QuestionnaireContent questionnaireContent) {
    return  !questionnaireDao.existsById(questionnaireContent.getQuestionnaire().getId()) ||
            !StringUtils.hasText(questionnaireContent.getQuestion()) ||
            !StringUtils.hasText(questionnaireContent.getOptions()) ||
            !StringUtils.hasText(questionnaireContent.getType());
  }
}
