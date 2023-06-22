package com.example.questionnaire_backstage.service.ifs;


import com.example.questionnaire_backstage.vo.QuestionnaireRequest;
import com.example.questionnaire_backstage.vo.QuestionnaireResponse;

public interface QuestionnaireService {

  // 新增
  public QuestionnaireResponse addQuestionnaire(QuestionnaireRequest questionnaireRequest);

  // 刪除
  public QuestionnaireResponse deleteQuestionnaire(QuestionnaireRequest questionnaireRequest);
}