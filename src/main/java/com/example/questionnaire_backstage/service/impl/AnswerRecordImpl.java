package com.example.questionnaire_backstage.service.impl;

import com.example.questionnaire_backstage.service.ifs.AnswerRecordService;
import com.example.questionnaire_backstage.vo.AnswerRecordRequest;
import com.example.questionnaire_backstage.vo.AnswerRecordResponse;
import org.springframework.stereotype.Service;

@Service
public class AnswerRecordImpl implements AnswerRecordService {
  @Override
  public AnswerRecordResponse addAnswerRecord(AnswerRecordRequest answerRecordRequest) {
    return null;
  }

  @Override
  public AnswerRecordResponse deleteAnswerRecord(AnswerRecordRequest answerRecordRequest) {
    return null;
  }

  @Override
  public AnswerRecordResponse findByAnswerRecordId(AnswerRecordRequest answerRecordRequest) {
    return null;
  }

  @Override
  public AnswerRecordResponse findByUserIdFromAnswerRecord(AnswerRecordRequest answerRecordRequest) {
    return null;
  }

  @Override
  public AnswerRecordResponse findByQuestionnaireIdFromAnswerRecord(AnswerRecordRequest answerRecordRequest) {
    return null;
  }
}
