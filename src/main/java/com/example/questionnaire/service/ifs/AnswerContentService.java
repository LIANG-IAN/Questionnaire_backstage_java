package com.example.questionnaire.service.ifs;

import com.example.questionnaire.vo.AnswerContentRequest;
import com.example.questionnaire.vo.AnswerContentResponse;

public interface AnswerContentService {

  // 新增人回答
  // 重複回答視為更新
  public AnswerContentResponse addAnswerContent(AnswerContentRequest answerContentRequest);

  // 刪除人回答
  public AnswerContentResponse deleteAnswerContent(AnswerContentRequest answerContentRequest);

  // Id搜尋人回答
  public AnswerContentResponse findByAnswerContentId(AnswerContentRequest answerContentRequest);

  // 透過外鍵搜尋人回答
  public AnswerContentResponse findByQuestionnaireIdFromAnswerContent(AnswerContentRequest answerContentRequest);
}
