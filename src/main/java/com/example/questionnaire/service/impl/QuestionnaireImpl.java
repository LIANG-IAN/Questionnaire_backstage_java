package com.example.questionnaire.service.impl;

import com.example.questionnaire.constants.RtnCode;
import com.example.questionnaire.entity.Questionnaire;
import com.example.questionnaire.repository.QuestionnaireDao;
import com.example.questionnaire.service.ifs.QuestionnaireService;
import com.example.questionnaire.vo.QuestionnaireRequest;
import com.example.questionnaire.vo.QuestionnaireResponse;
import com.example.questionnaire.vo.QuestionnaireSearchRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class QuestionnaireImpl implements QuestionnaireService {

  @Autowired
  QuestionnaireDao questionnaireDao;


  @Override
  public QuestionnaireResponse addQuestionnaire(QuestionnaireRequest questionnaireRequest) {
    Questionnaire questionnaire = questionnaireRequest.getQuestionnaire();

    // 判斷各參數是否符合規定
    if (questionnaire == null || isQuestionnaireLegal(questionnaire)) {
      return new QuestionnaireResponse(RtnCode.INCORRECT_INFO_ERROR.getMessage());
    }

    questionnaireDao.save(questionnaire);

    return new QuestionnaireResponse(RtnCode.ADD_SUCCESS.getMessage());
  }

  @Override
  public QuestionnaireResponse deleteQuestionnaire(QuestionnaireRequest questionnaireRequest) {
    List<Integer> idList = questionnaireRequest.getIdList();

    // 非空判斷
    if (CollectionUtils.isEmpty(idList)) {
      return new QuestionnaireResponse(RtnCode.INCORRECT_INFO_ERROR.getMessage());
    }

    List<Integer> correctIdList = new ArrayList<>();

    for (Integer id : idList) {

      // 判斷Id是否符合規定
      if (id <= 0) {
        continue;
      }

      correctIdList.add(id);

    }

    questionnaireDao.deleteAllById(correctIdList);

    return new QuestionnaireResponse(RtnCode.DELETE_SUCCESS.getMessage());
  }

  @Override
  public QuestionnaireResponse modifyQuestionnaire(QuestionnaireRequest questionnaireRequest) {
    Questionnaire newQuestionnaire = questionnaireRequest.getQuestionnaire();

    // 判斷各參數是否符合規定
    if (newQuestionnaire == null || isQuestionnaireLegal(newQuestionnaire)) {
      return new QuestionnaireResponse(RtnCode.INCORRECT_INFO_ERROR.getMessage());
    }

    // 判斷問卷是否存在
    if (!questionnaireDao.existsById(newQuestionnaire.getId())) {
      return new QuestionnaireResponse(RtnCode.NOT_FOUND.getMessage());
    }

    questionnaireDao.save(newQuestionnaire);
    return new QuestionnaireResponse(RtnCode.MODIFY_SUCCESS.getMessage());
  }

  @Override
  public QuestionnaireResponse findByQuestionnaireId(QuestionnaireRequest questionnaireRequest) {
    int id = questionnaireRequest.getId();

    // 判斷Id是否符合規定
    if (id <= 0) {
      return new QuestionnaireResponse(RtnCode.INCORRECT_INFO_ERROR.getMessage());
    }

    // 判斷是否有匹配問卷
    Optional<Questionnaire> temp = questionnaireDao.findById(id);
    if (temp.isEmpty()) {
      return new QuestionnaireResponse(RtnCode.NOT_FOUND.getMessage());
    }

    Questionnaire questionnaire = temp.get();

    return new QuestionnaireResponse(questionnaire, RtnCode.FIND_SUCCESS.getMessage());
  }

  @Override
  public QuestionnaireResponse findAll() {

    return new QuestionnaireResponse(questionnaireDao.findAll(), RtnCode.FIND_SUCCESS.getMessage());
  }

  @Override
  public QuestionnaireResponse findByQuestionnaireFuzzySearch(QuestionnaireSearchRequest questionnaireSearchRequest) {
    String questionnaire = questionnaireSearchRequest.getQuestionnaire();

    // 非空判斷
    if (!StringUtils.hasText(questionnaire)) {
      return new QuestionnaireResponse(RtnCode.INCORRECT_INFO_ERROR.getMessage());
    }

    List<Questionnaire> questionnaireList = questionnaireDao.findByQuestionnaireFuzzySearch(questionnaire);

    // 判斷是否有匹配問卷
    if (CollectionUtils.isEmpty(questionnaireList)) {
      return new QuestionnaireResponse(RtnCode.NOT_FOUND.getMessage());
    }

    return new QuestionnaireResponse(questionnaireList, RtnCode.FIND_SUCCESS.getMessage());
  }

  @Override
  public QuestionnaireResponse findByStartingTime(QuestionnaireSearchRequest questionnaireSearchRequest) {
    LocalDate stringTime = questionnaireSearchRequest.getStartingTime();

    // 非空判斷
    if (stringTime == null) {
      return new QuestionnaireResponse(RtnCode.INCORRECT_INFO_ERROR.getMessage());
    }

    List<Questionnaire> questionnaireList = questionnaireDao.findByStartingTime(stringTime);

    // 判斷是否有匹配問卷
    if (CollectionUtils.isEmpty(questionnaireList)) {
      return new QuestionnaireResponse(RtnCode.NOT_FOUND.getMessage());
    }

    return new QuestionnaireResponse(questionnaireList, RtnCode.FIND_SUCCESS.getMessage());
  }

  @Override
  public QuestionnaireResponse findByEndTime(QuestionnaireSearchRequest questionnaireSearchRequest) {
    LocalDate endTime = questionnaireSearchRequest.getEndTime();

    // 非空判斷
    if (endTime == null) {
      return new QuestionnaireResponse(RtnCode.INCORRECT_INFO_ERROR.getMessage());
    }

    List<Questionnaire> questionnaireList = questionnaireDao.findByEndTime(endTime);

    // 判斷是否有匹配問卷
    if (CollectionUtils.isEmpty(questionnaireList)) {
      return new QuestionnaireResponse(RtnCode.NOT_FOUND.getMessage());
    }

    return new QuestionnaireResponse(questionnaireList, RtnCode.FIND_SUCCESS.getMessage());
  }

  @Override
  public QuestionnaireResponse findByStartingTimeBetween(QuestionnaireSearchRequest questionnaireSearchRequest) {
    LocalDate stringTime = questionnaireSearchRequest.getStartingTime();
    LocalDate endTime = questionnaireSearchRequest.getEndTime();

    // 非空判斷
    if (stringTime == null || endTime == null) {
      return new QuestionnaireResponse(RtnCode.INCORRECT_INFO_ERROR.getMessage());
    }

    List<Questionnaire> questionnaireList = questionnaireDao.findByStartingTimeGreaterThanEqualAndEndTimeLessThanEqual(stringTime, endTime);

    // 判斷是否有匹配問卷
    if (CollectionUtils.isEmpty(questionnaireList)) {
      return new QuestionnaireResponse(RtnCode.NOT_FOUND.getMessage());
    }

    return new QuestionnaireResponse(questionnaireList, RtnCode.FIND_SUCCESS.getMessage());
  }

  @Override
  public QuestionnaireResponse findByStartingTimeGreaterThan(QuestionnaireSearchRequest questionnaireSearchRequest) {
    LocalDate stringTime = questionnaireSearchRequest.getStartingTime();

    // 非空判斷
    if (stringTime == null) {
      return new QuestionnaireResponse(RtnCode.INCORRECT_INFO_ERROR.getMessage());
    }

    List<Questionnaire> questionnaireList = questionnaireDao.findByStartingTimeGreaterThanEqual(stringTime);

    // 判斷是否有匹配問卷
    if (CollectionUtils.isEmpty(questionnaireList)) {
      return new QuestionnaireResponse(RtnCode.NOT_FOUND.getMessage());
    }

    return new QuestionnaireResponse(questionnaireList, RtnCode.FIND_SUCCESS.getMessage());
  }

  @Override
  public QuestionnaireResponse findByEndTimeLessThan(QuestionnaireSearchRequest questionnaireSearchRequest) {
    LocalDate endTime = questionnaireSearchRequest.getEndTime();

    // 非空判斷
    if (endTime == null) {
      return new QuestionnaireResponse(RtnCode.INCORRECT_INFO_ERROR.getMessage());
    }

    List<Questionnaire> questionnaireList = questionnaireDao.findByEndTimeLessThanEqual(endTime);

    // 判斷是否有匹配問卷
    if (CollectionUtils.isEmpty(questionnaireList)) {
      return new QuestionnaireResponse(RtnCode.NOT_FOUND.getMessage());
    }

    return new QuestionnaireResponse(questionnaireList, RtnCode.FIND_SUCCESS.getMessage());

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