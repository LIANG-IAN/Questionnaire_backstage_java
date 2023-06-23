package com.example.questionnaire_backstage.service.ifs;

import com.example.questionnaire_backstage.vo.QuestionnaireContentRequest;
import com.example.questionnaire_backstage.vo.QuestionnaireContentResponse;

public interface QuestionnaireContentService {

  // 新增問卷問題(批次)
  public QuestionnaireContentResponse addQuestionnaireContent(QuestionnaireContentRequest questionnaireContentRequest);

  // 刪除問卷問題(批次)
  public QuestionnaireContentResponse deleteQuestionnaireContent(QuestionnaireContentRequest questionnaireContentRequest);

  // 修改問卷問題(批次)
  public QuestionnaireContentResponse modifyQuestionnaireContent(QuestionnaireContentRequest questionnaireContentRequest);

  // 透過外鍵搜尋所有問題
  public QuestionnaireContentResponse findAllByQuestionnaireId(QuestionnaireContentRequest questionnaireContentRequest);
}
