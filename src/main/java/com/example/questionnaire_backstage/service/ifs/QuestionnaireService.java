package com.example.questionnaire_backstage.service.ifs;


import com.example.questionnaire_backstage.entity.Questionnaire;
import com.example.questionnaire_backstage.vo.QuestionnaireRequest;
import com.example.questionnaire_backstage.vo.QuestionnaireResponse;
import com.example.questionnaire_backstage.vo.QuestionnaireSearchRequest;
import com.example.questionnaire_backstage.vo.QuestionnaireSearchResponse;

import java.time.LocalDate;
import java.util.List;

public interface QuestionnaireService {

  // 新增
  public QuestionnaireResponse addQuestionnaire(QuestionnaireRequest questionnaireRequest);

  // 刪除
  public QuestionnaireResponse deleteQuestionnaire(QuestionnaireRequest questionnaireRequest);

  // 修改
  public QuestionnaireResponse modifyQuestionnaire(QuestionnaireRequest questionnaireRequest);

  // 查
  public QuestionnaireResponse findById(QuestionnaireRequest questionnaireRequest);

  // 尋找全部問卷
  public QuestionnaireSearchResponse findAll();

  // 模糊搜尋問卷
  public QuestionnaireSearchResponse findByQuestionnaireFuzzySearch(QuestionnaireSearchRequest questionnaireSearchRequest);

  // 開始時間搜尋問卷
  public QuestionnaireSearchResponse findByStartingTime(QuestionnaireSearchRequest questionnaireSearchRequest);

  // 結束時間搜尋問卷
  public QuestionnaireSearchResponse findByEndTime(QuestionnaireSearchRequest questionnaireSearchRequest);

  // 時間區間搜尋
  public QuestionnaireSearchResponse findByStartingTimeBetween(QuestionnaireSearchRequest questionnaireSearchRequest);

  // 開始時間以後搜尋
  public QuestionnaireSearchResponse findByStartingTimeGreaterThan(QuestionnaireSearchRequest questionnaireSearchRequest);

  // 結束時間以前搜尋
  public QuestionnaireSearchResponse findByEndTimeLessThan(QuestionnaireSearchRequest questionnaireSearchRequest);
}

