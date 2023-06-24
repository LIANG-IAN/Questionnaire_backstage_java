package com.example.questionnaire_backstage.service.ifs;

import com.example.questionnaire_backstage.vo.AnswerRecordRequest;
import com.example.questionnaire_backstage.vo.AnswerRecordResponse;

public interface AnswerRecordService {

  // 新增人回答紀錄
  public AnswerRecordResponse addAnswerRecord(AnswerRecordRequest answerRecordRequest);

  // 刪除人回答紀錄
  public AnswerRecordResponse deleteAnswerRecord(AnswerRecordRequest answerRecordRequest);

  // Id搜尋人回答紀錄
  public AnswerRecordResponse findByAnswerRecordId(AnswerRecordRequest answerRecordRequest);

  // 外鍵UserId搜尋人回答紀錄
  public AnswerRecordResponse findByUserIdFromAnswerRecord(AnswerRecordRequest answerRecordRequest);

  // 外鍵QuestionnaireId搜尋人回答紀錄
  public AnswerRecordResponse findByQuestionnaireIdFromAnswerRecord(AnswerRecordRequest answerRecordRequest);
}
