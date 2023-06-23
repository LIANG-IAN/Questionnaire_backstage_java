package com.example.questionnaire_backstage.service.impl;

import com.example.questionnaire_backstage.constants.RtnCode;
import com.example.questionnaire_backstage.entity.Questionnaire;
import com.example.questionnaire_backstage.repository.QuestionnaireDao;
import com.example.questionnaire_backstage.service.ifs.QuestionnaireService;
import com.example.questionnaire_backstage.vo.QuestionnaireRequest;
import com.example.questionnaire_backstage.vo.QuestionnaireResponse;
import com.example.questionnaire_backstage.vo.QuestionnaireSearchRequest;
import com.example.questionnaire_backstage.vo.QuestionnaireSearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class QuestionnaireImpl implements QuestionnaireService {

  @Autowired
  QuestionnaireDao questionnaireDao;


  // 新增
  @Override
  public QuestionnaireResponse addQuestionnaire(QuestionnaireRequest questionnaireRequest) {
    Questionnaire questionnaire = questionnaireRequest.getQuestionnaire();

    // 判斷各參數是否符合規定
    if (questionnaire == null || isQuestionnaireLegal(questionnaire)) {
      return new QuestionnaireResponse(RtnCode.INPUT_NOT_ALLOWED_BLANK_ERROR.getMessage());
    }

    questionnaireDao.save(questionnaire);

    return new QuestionnaireResponse(RtnCode.ADD_QUESTIONNAIRE_SUCCESS.getMessage());
  }

  // 刪除
  @Override
  public QuestionnaireResponse deleteQuestionnaire(QuestionnaireRequest questionnaireRequest) {
    int id = questionnaireRequest.getId();

    // 判斷Id是否符合規定
    if (id <= 0) {
      return new QuestionnaireResponse(RtnCode.INPUT_NOT_ALLOWED_BLANK_ERROR.getMessage());
    }

    questionnaireDao.deleteById(id);

    return new QuestionnaireResponse(RtnCode.DELETE_SUCCESS.getMessage());
  }

  @Override
  public QuestionnaireResponse modifyQuestionnaire(QuestionnaireRequest questionnaireRequest) {
    Questionnaire newQuestionnaire = questionnaireRequest.getQuestionnaire();

    // 判斷各參數是否符合規定
    if (newQuestionnaire == null || isQuestionnaireLegal(newQuestionnaire)) {
      return new QuestionnaireResponse(RtnCode.INPUT_NOT_ALLOWED_BLANK_ERROR.getMessage());
    }

    // 判斷問卷是否存在
    if (!questionnaireDao.existsById(newQuestionnaire.getId())) {
      return new QuestionnaireResponse(RtnCode.NOT_FOUND.getMessage());
    }

    questionnaireDao.save(newQuestionnaire);
    return new QuestionnaireResponse(RtnCode.MODIFY_SUCCESS.getMessage());
  }

  @Override
  public QuestionnaireResponse findById(QuestionnaireRequest questionnaireRequest) {
    int id = questionnaireRequest.getId();

    // 判斷Id是否符合規定
    if (id <= 0) {
      return new QuestionnaireResponse(RtnCode.INPUT_NOT_ALLOWED_BLANK_ERROR.getMessage());
    }

    // 判斷是否有匹配問卷
    Optional<Questionnaire> temp = questionnaireDao.findById(id);
    if (temp.isEmpty()){
      return new QuestionnaireResponse(RtnCode.NOT_FOUND.getMessage());
    }

    Questionnaire questionnaire = temp.get();

    return new QuestionnaireResponse(questionnaire, RtnCode.FIND_SUCCESS.getMessage());
  }

  @Override
  public QuestionnaireSearchResponse findAll() {

    return new QuestionnaireSearchResponse(questionnaireDao.findAll(), RtnCode.FIND_SUCCESS.getMessage());
  }

  @Override
  public QuestionnaireSearchResponse findByQuestionnaireFuzzySearch(QuestionnaireSearchRequest questionnaireSearchRequest) {
    String questionnaire = questionnaireSearchRequest.getQuestionnaire();

    // 非空判斷
    if (!StringUtils.hasText(questionnaire)) {
      return new QuestionnaireSearchResponse(RtnCode.INPUT_NOT_ALLOWED_BLANK_ERROR.getMessage());
    }

    List<Questionnaire> questionnaireList = questionnaireDao.findByQuestionnaireFuzzySearch(questionnaire);

    // 判斷是否有匹配問卷
    if (CollectionUtils.isEmpty(questionnaireList)) {
      return new QuestionnaireSearchResponse(RtnCode.NOT_FOUND.getMessage());
    }

    return new QuestionnaireSearchResponse(questionnaireList, RtnCode.FIND_SUCCESS.getMessage());
  }

  @Override
  public QuestionnaireSearchResponse findByStartingTime(QuestionnaireSearchRequest questionnaireSearchRequest) {
    LocalDate stringTime = questionnaireSearchRequest.getStartingTime();

    // 非空判斷
    if (stringTime == null) {
      return new QuestionnaireSearchResponse(RtnCode.INPUT_NOT_ALLOWED_BLANK_ERROR.getMessage());
    }

    List<Questionnaire> questionnaireList = questionnaireDao.findByStartingTime(stringTime);

    // 判斷是否有匹配問卷
    if (CollectionUtils.isEmpty(questionnaireList)) {
      return new QuestionnaireSearchResponse(RtnCode.NOT_FOUND.getMessage());
    }

    return new QuestionnaireSearchResponse(questionnaireList, RtnCode.FIND_SUCCESS.getMessage());
  }

  @Override
  public QuestionnaireSearchResponse findByEndTime(QuestionnaireSearchRequest questionnaireSearchRequest) {
    LocalDate endTime = questionnaireSearchRequest.getEndTime();

    // 非空判斷
    if (endTime == null) {
      return new QuestionnaireSearchResponse(RtnCode.INPUT_NOT_ALLOWED_BLANK_ERROR.getMessage());
    }

    List<Questionnaire> questionnaireList = questionnaireDao.findByEndTime(endTime);

    // 判斷是否有匹配問卷
    if (CollectionUtils.isEmpty(questionnaireList)) {
      return new QuestionnaireSearchResponse(RtnCode.NOT_FOUND.getMessage());
    }

    return new QuestionnaireSearchResponse(questionnaireList, RtnCode.FIND_SUCCESS.getMessage());
  }

  @Override
  public QuestionnaireSearchResponse findByStartingTimeBetween(QuestionnaireSearchRequest questionnaireSearchRequest) {
    LocalDate stringTime = questionnaireSearchRequest.getStartingTime();
    LocalDate endTime = questionnaireSearchRequest.getEndTime();

    // 非空判斷
    if (stringTime == null || endTime == null) {
      return new QuestionnaireSearchResponse(RtnCode.INPUT_NOT_ALLOWED_BLANK_ERROR.getMessage());
    }

    List<Questionnaire> questionnaireList = questionnaireDao.findByStartingTimeGreaterThanEqualAndEndTimeLessThanEqual(stringTime, endTime);

    // 判斷是否有匹配問卷
    if (CollectionUtils.isEmpty(questionnaireList)) {
      return new QuestionnaireSearchResponse(RtnCode.NOT_FOUND.getMessage());
    }

    return new QuestionnaireSearchResponse(questionnaireList, RtnCode.FIND_SUCCESS.getMessage());
  }

  @Override
  public QuestionnaireSearchResponse findByStartingTimeGreaterThan(QuestionnaireSearchRequest questionnaireSearchRequest) {
    LocalDate stringTime = questionnaireSearchRequest.getStartingTime();

    // 非空判斷
    if (stringTime == null) {
      return new QuestionnaireSearchResponse(RtnCode.INPUT_NOT_ALLOWED_BLANK_ERROR.getMessage());
    }

    List<Questionnaire> questionnaireList = questionnaireDao.findByStartingTimeGreaterThanEqual(stringTime);

    // 判斷是否有匹配問卷
    if (CollectionUtils.isEmpty(questionnaireList)) {
      return new QuestionnaireSearchResponse(RtnCode.NOT_FOUND.getMessage());
    }

    return new QuestionnaireSearchResponse(questionnaireList, RtnCode.FIND_SUCCESS.getMessage());
  }

  @Override
  public QuestionnaireSearchResponse findByEndTimeLessThan(QuestionnaireSearchRequest questionnaireSearchRequest) {
    LocalDate endTime = questionnaireSearchRequest.getEndTime();

    // 非空判斷
    if (endTime == null) {
      return new QuestionnaireSearchResponse(RtnCode.INPUT_NOT_ALLOWED_BLANK_ERROR.getMessage());
    }

    List<Questionnaire> questionnaireList = questionnaireDao.findByEndTimeLessThanEqual(endTime);

    // 判斷是否有匹配問卷
    if (CollectionUtils.isEmpty(questionnaireList)) {
      return new QuestionnaireSearchResponse(RtnCode.NOT_FOUND.getMessage());
    }

    return new QuestionnaireSearchResponse(questionnaireList, RtnCode.FIND_SUCCESS.getMessage());

  }

  // 檢查物件Questionnaire，不合規定返回true
  private boolean isQuestionnaireLegal(Questionnaire questionnaire) {
    return !StringUtils.hasText(questionnaire.getQuestionnaire()) ||
            !StringUtils.hasText(questionnaire.getMainPoint()) ||
            questionnaire.getStartingTime() == null ||
            questionnaire.getEndTime() == null ||
            questionnaire.getStartingTime().compareTo(questionnaire.getEndTime()) >= 0;
  }
}