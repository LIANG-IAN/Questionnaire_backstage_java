package com.example.questionnaire.service.impl;

import com.example.questionnaire.constants.RtnCode;
import com.example.questionnaire.entity.AnswerContent;
import com.example.questionnaire.repository.AnswerContentDao;
import com.example.questionnaire.repository.QuestionnaireContentDao;
import com.example.questionnaire.repository.QuestionnaireDao;
import com.example.questionnaire.repository.UserDao;
import com.example.questionnaire.service.ifs.AnswerContentService;
import com.example.questionnaire.vo.AnswerContentRequest;
import com.example.questionnaire.vo.AnswerContentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AnswerContentImpl implements AnswerContentService {

  @Autowired
  AnswerContentDao answerContentDao;

  @Autowired
  QuestionnaireDao questionnaireDao;

  @Autowired
  QuestionnaireContentDao questionnaireContentDao;

  @Autowired
  UserDao userDao;


  @Override
  public AnswerContentResponse addAnswerContent(AnswerContentRequest answerContentRequest) {
    List<AnswerContent> answerContentList = answerContentRequest.getAnswerContentList();

    if (CollectionUtils.isEmpty(answerContentList)) {
      return new AnswerContentResponse(RtnCode.INCORRECT_INFO_ERROR.getMessage());
    }

    List<AnswerContent> correctAnswerContentList = new ArrayList<>();
    for (AnswerContent answerContent : answerContentList) {

      // 判斷資料是否符合規定
      if (isAnswerContentLegal(answerContent)) {
        return new AnswerContentResponse(RtnCode.INCORRECT_INFO_ERROR.getMessage());
      }

      if (!StringUtils.hasText(answerContent.getAnswer())){
        continue;
      }

      // 判斷是否重複作答
      AnswerContent oldAnswerContent = repeatAnswer(answerContent);
      if (oldAnswerContent != null) {
        oldAnswerContent.setAnswer(answerContent.getAnswer());
        answerContentDao.save(oldAnswerContent);
      }

      correctAnswerContentList.add(answerContent);
    }
    answerContentDao.saveAll(correctAnswerContentList);

    return new AnswerContentResponse(RtnCode.ADD_SUCCESS.getMessage());
  }

  @Override
  public AnswerContentResponse deleteAnswerContent(AnswerContentRequest answerContentRequest) {
    int id = answerContentRequest.getId();

    // 判斷Id是否符合規定
    if (id <= 0) {
      return new AnswerContentResponse(RtnCode.INCORRECT_INFO_ERROR.getMessage());
    }

    answerContentDao.deleteById(id);

    return new AnswerContentResponse(RtnCode.DELETE_SUCCESS.getMessage());
  }

  @Override
  public AnswerContentResponse findByAnswerContentId(AnswerContentRequest answerContentRequest) {
    int id = answerContentRequest.getId();

    // 判斷Id是否符合規定
    if (id <= 0) {
      return new AnswerContentResponse(RtnCode.INCORRECT_INFO_ERROR.getMessage());
    }

    // 檢查是否存在
    Optional<AnswerContent> temp = answerContentDao.findById(id);
    if (temp.isEmpty()) {
      return new AnswerContentResponse(RtnCode.NOT_FOUND.getMessage());
    }

    AnswerContent answerContent = temp.get();

    return new AnswerContentResponse(answerContent, RtnCode.FIND_SUCCESS.getMessage());
  }

  @Override
  public AnswerContentResponse findByQuestionnaireIdFromAnswerContent(AnswerContentRequest answerContentRequest) {
    int questionnaireId = answerContentRequest.getQuestionnaireId();

    // 判斷Id是否符合規定
    if (questionnaireId <= 0) {
      return new AnswerContentResponse(RtnCode.INCORRECT_INFO_ERROR.getMessage());
    }

    // 判斷問卷是否存在
    if (!questionnaireDao.existsById(questionnaireId)) {
      return new AnswerContentResponse(RtnCode.NOT_FOUND.getMessage());
    }

    List<AnswerContent> answerContentList = answerContentDao.findByQuestionnaireId(questionnaireId);

    // 判斷是否有相符人回答
    if (CollectionUtils.isEmpty(answerContentList)) {
      return new AnswerContentResponse(RtnCode.NOT_FOUND.getMessage());
    }

    return new AnswerContentResponse(answerContentList, RtnCode.FIND_SUCCESS.getMessage());
  }


  // 判斷物件AnswerContent是否符合規定，不符合返回true
  private boolean isAnswerContentLegal(AnswerContent answerContent) {
    return answerContent.getUser().getId() <= 0 ||
            answerContent.getQuestionnaire().getId() <= 0 ||
            answerContent.getQuestionnaireContent().getId() <= 0 ||
            !userDao.existsById(answerContent.getUser().getId()) ||
            !questionnaireDao.existsById(answerContent.getQuestionnaire().getId()) ||
            !questionnaireContentDao.existsById(answerContent.getQuestionnaireContent().getId());
  }

  // 判斷是否重複作答，有則返回舊回答
  private AnswerContent repeatAnswer(AnswerContent answerContent) {
    return answerContentDao.findByUserIdAndQuestionnaireIdAndQuestionnaireContentId(
            answerContent.getUser().getId(),
            answerContent.getQuestionnaire().getId(),
            answerContent.getQuestionnaireContent().getId()
    );
  }
}
