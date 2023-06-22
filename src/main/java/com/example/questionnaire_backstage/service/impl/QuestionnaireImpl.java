package com.example.questionnaire_backstage.service.impl;

import com.example.questionnaire_backstage.constants.RtnCode;
import com.example.questionnaire_backstage.entity.Questionnaire;
import com.example.questionnaire_backstage.repository.QuestionnaireDao;
import com.example.questionnaire_backstage.service.ifs.QuestionnaireService;
import com.example.questionnaire_backstage.vo.QuestionnaireRequest;
import com.example.questionnaire_backstage.vo.QuestionnaireResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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

    // 判斷Id是否符合規定
    if (questionnaireRequest.getId() <= 0) {
      return new QuestionnaireResponse(RtnCode.INPUT_NOT_ALLOWED_BLANK_ERROR.getMessage());
    }

    questionnaireDao.deleteById(questionnaireRequest.getId());

    return new QuestionnaireResponse(RtnCode.DELETE_SUCCESS.getMessage());
  }

  // 檢查物件Questionnaire，不合規定返回true
  private boolean isQuestionnaireLegal(Questionnaire questionnaire) {
    return  !StringUtils.hasText(questionnaire.getQuestionnaire()) ||
            !StringUtils.hasText(questionnaire.getMainPoint()) ||
            questionnaire.getStartingTime() == null ||
            questionnaire.getEndTime() == null;
  }
}