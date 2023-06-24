package com.example.questionnaire_backstage.service.impl;

import com.example.questionnaire_backstage.constants.RtnCode;
import com.example.questionnaire_backstage.entity.AnswerRecord;
import com.example.questionnaire_backstage.repository.AnswerRecordDao;
import com.example.questionnaire_backstage.repository.QuestionnaireDao;
import com.example.questionnaire_backstage.repository.UserDao;
import com.example.questionnaire_backstage.service.ifs.AnswerRecordService;
import com.example.questionnaire_backstage.vo.AnswerRecordRequest;
import com.example.questionnaire_backstage.vo.AnswerRecordResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerRecordImpl implements AnswerRecordService {

  @Autowired
  AnswerRecordDao answerRecordDao;

  @Autowired
  QuestionnaireDao questionnaireDao;

  @Autowired
  UserDao userDao;



  @Override
  public AnswerRecordResponse addAnswerRecord(AnswerRecordRequest answerRecordRequest) {
    AnswerRecord answerRecord = answerRecordRequest.getAnswerRecord();

    if (isAnswerRecordLegal(answerRecord)){
      return new AnswerRecordResponse(RtnCode.INCORRECT_INFO_ERROR.getMessage());
    }

    // 判斷是否重複答題
    AnswerRecord oldAnswerRecord = repeatAnswer(answerRecord);
    if (oldAnswerRecord != null){
      oldAnswerRecord.setFillingTime(answerRecord.getFillingTime());

      answerRecordDao.save(oldAnswerRecord);

      return new AnswerRecordResponse(RtnCode.ADD_SUCCESS.getMessage());
    }

    answerRecordDao.save(answerRecord);

    return new AnswerRecordResponse(RtnCode.ADD_SUCCESS.getMessage());
  }

  @Override
  public AnswerRecordResponse deleteAnswerRecord(AnswerRecordRequest answerRecordRequest) {
    int id = answerRecordRequest.getId();

    // 判斷Id是否符合規定
    if (id <= 0){
      return new AnswerRecordResponse(RtnCode.INCORRECT_INFO_ERROR.getMessage());
    }

    answerRecordDao.deleteById(id);

    return new AnswerRecordResponse(RtnCode.DELETE_SUCCESS.getMessage());
  }

  @Override
  public AnswerRecordResponse findByAnswerRecordId(AnswerRecordRequest answerRecordRequest) {
    int id = answerRecordRequest.getId();

    // 判斷Id是否符合規定
    if (id <= 0){
      return new AnswerRecordResponse(RtnCode.INCORRECT_INFO_ERROR.getMessage());
    }

    // 判斷人回答紀錄是否存在
    Optional<AnswerRecord> temp = answerRecordDao.findById(id);
    if (temp.isEmpty()){
      return new AnswerRecordResponse(RtnCode.NOT_FOUND.getMessage());
    }

    AnswerRecord answerRecord = temp.get();

    return new AnswerRecordResponse(answerRecord,RtnCode.FIND_SUCCESS.getMessage());
  }

  @Override
  public AnswerRecordResponse findAllByQuestionnaireIdFromAnswerRecordOrder(AnswerRecordRequest answerRecordRequest) {
    int questionnaireId = answerRecordRequest.getQuestionnaireId();

    // 判斷Id是否符合規定
    if (questionnaireId <= 0){
      return new AnswerRecordResponse(RtnCode.INCORRECT_INFO_ERROR.getMessage());
    }

    List<AnswerRecord> answerRecordList = answerRecordDao.findAllByQuestionnaireIdFromAnswerRecordOrder(questionnaireId);

    // 判斷是否有相符資料
    if (CollectionUtils.isEmpty(answerRecordList)){
      return new AnswerRecordResponse(RtnCode.NOT_FOUND.getMessage());
    }

    return new AnswerRecordResponse(answerRecordList,RtnCode.FIND_SUCCESS.getMessage());
  }


  // 檢查物件AnswerRecord，不合規定返回true
  private boolean isAnswerRecordLegal(AnswerRecord answerRecord) {
    return questionnaireDao.existsById(answerRecord.getQuestionnaire().getId()) ||
            userDao.existsById(answerRecord.getUser().getId()) ||
            answerRecord.getFillingTime() == null;
  }

  // 判斷是否重複答題
  private AnswerRecord repeatAnswer(AnswerRecord answerRecord){
    return answerRecordDao.findByUserIdAndQuestionnaireId(answerRecord.getUser().getId(),answerRecord.getQuestionnaire().getId());
  }
}
