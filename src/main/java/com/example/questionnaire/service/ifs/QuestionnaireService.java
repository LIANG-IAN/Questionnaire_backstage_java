package com.example.questionnaire.service.ifs;


import com.example.questionnaire.entity.Questionnaire;
import com.example.questionnaire.vo.QuestionnaireRequest;
import com.example.questionnaire.vo.QuestionnaireResponse;
import com.example.questionnaire.vo.QuestionnaireSearchRequest;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface QuestionnaireService {

  // 新增
  public QuestionnaireResponse addQuestionnaire(QuestionnaireRequest questionnaireRequest);

  // 批次刪除
  public QuestionnaireResponse deleteQuestionnaire(QuestionnaireRequest questionnaireRequest);

  // 修改
  public QuestionnaireResponse modifyQuestionnaire(QuestionnaireRequest questionnaireRequest);

  // 查
  public QuestionnaireResponse findByQuestionnaireId(QuestionnaireRequest questionnaireRequest);

  // 尋找全部問卷
  public QuestionnaireResponse findAll();

  // 模糊搜尋問卷
  public QuestionnaireResponse findByQuestionnaireFuzzySearch(QuestionnaireSearchRequest questionnaireSearchRequest);

  // 開始時間搜尋問卷
  public QuestionnaireResponse findByStartingTime(QuestionnaireSearchRequest questionnaireSearchRequest);

  // 結束時間搜尋問卷
  public QuestionnaireResponse findByEndTime(QuestionnaireSearchRequest questionnaireSearchRequest);

  // 時間區間搜尋
  public QuestionnaireResponse findByStartingTimeBetween(QuestionnaireSearchRequest questionnaireSearchRequest);

  // 開始時間以後搜尋
  public QuestionnaireResponse findByStartingTimeGreaterThan(QuestionnaireSearchRequest questionnaireSearchRequest);

  // 結束時間以前搜尋
  public QuestionnaireResponse findByEndTimeLessThan(QuestionnaireSearchRequest questionnaireSearchRequest);

  // 開始時間與模糊搜尋
  public QuestionnaireResponse findByQuestionnaireFuzzySearchAndStartingTimeThanEqual(QuestionnaireSearchRequest questionnaireSearchRequest);

  // 結束時間與模糊搜尋
  public QuestionnaireResponse findByQuestionnaireFuzzySearchAndEndTimeLessThanEqual(QuestionnaireSearchRequest questionnaireSearchRequest);

  // 時間區間與模糊搜尋
  public QuestionnaireResponse findByQuestionnaireFuzzySearchStartingTimeThanEqualAndEndTimeLessThanEqual(QuestionnaireSearchRequest questionnaireSearchRequest);
}

