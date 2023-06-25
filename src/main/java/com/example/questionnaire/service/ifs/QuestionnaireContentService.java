package com.example.questionnaire.service.ifs;

import com.example.questionnaire.vo.QuestionnaireContentRequest;
import com.example.questionnaire.vo.QuestionnaireContentResponse;

public interface QuestionnaireContentService {

  // 新增問卷問題(批次)
  public QuestionnaireContentResponse addQuestionnaireContent(QuestionnaireContentRequest questionnaireContentRequest);

  // 刪除問卷問題(批次)
  public QuestionnaireContentResponse deleteQuestionnaireContent(QuestionnaireContentRequest questionnaireContentRequest);

  // 修改問卷問題(批次)
  public QuestionnaireContentResponse modifyQuestionnaireContent(QuestionnaireContentRequest questionnaireContentRequest);

  // 透過外鍵搜尋所有問題
  public QuestionnaireContentResponse findAllByQuestionnaireId(QuestionnaireContentRequest questionnaireContentRequest);

  // id搜尋
  public QuestionnaireContentResponse findByQuestionnaireContentId(QuestionnaireContentRequest questionnaireContentRequest);
}
