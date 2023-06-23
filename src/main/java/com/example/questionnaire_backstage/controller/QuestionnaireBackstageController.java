package com.example.questionnaire_backstage.controller;

import com.example.questionnaire_backstage.service.ifs.QuestionnaireService;
import com.example.questionnaire_backstage.vo.QuestionnaireRequest;
import com.example.questionnaire_backstage.vo.QuestionnaireResponse;
import com.example.questionnaire_backstage.vo.QuestionnaireSearchRequest;
import com.example.questionnaire_backstage.vo.QuestionnaireSearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class QuestionnaireBackstageController {

  @Autowired
  QuestionnaireService questionnaireService;


  @PostMapping(value = "addQuestionnaire")
  public QuestionnaireResponse addQuestionnaire(@RequestBody QuestionnaireRequest questionnaireRequest) {
    return questionnaireService.addQuestionnaire(questionnaireRequest);
  }

  @PostMapping(value = "deleteQuestionnaire")
  public QuestionnaireResponse deleteQuestionnaire(@RequestBody QuestionnaireRequest questionnaireRequest) {
    return questionnaireService.deleteQuestionnaire(questionnaireRequest);
  }

  @PostMapping(value = "modifyQuestionnaire")
  public QuestionnaireResponse modifyQuestionnaire(@RequestBody QuestionnaireRequest questionnaireRequest) {
    return questionnaireService.modifyQuestionnaire(questionnaireRequest);
  }

  @PostMapping(value = "findById")
  public QuestionnaireResponse findById(@RequestBody QuestionnaireRequest questionnaireRequest) {
    return questionnaireService.findById(questionnaireRequest);
  }

  @GetMapping(value = "findAll")
  public QuestionnaireSearchResponse findAll() {
    return questionnaireService.findAll();
  }

  @PostMapping(value = "findByQuestionnaireFuzzySearch")
  public QuestionnaireSearchResponse findByQuestionnaireFuzzySearch(@RequestBody QuestionnaireSearchRequest questionnaireSearchRequest) {
    return questionnaireService.findByQuestionnaireFuzzySearch(questionnaireSearchRequest);
  }

  @PostMapping(value = "findByStartingTime")
  public QuestionnaireSearchResponse findByStartingTime(@RequestBody QuestionnaireSearchRequest questionnaireSearchRequest) {
    return questionnaireService.findByStartingTime(questionnaireSearchRequest);
  }

  @PostMapping(value = "findByEndTime")
  public QuestionnaireSearchResponse findByEndTime(@RequestBody QuestionnaireSearchRequest questionnaireSearchRequest) {
    return questionnaireService.findByEndTime(questionnaireSearchRequest);
  }

  @PostMapping(value = "findByStartingTimeBetween")
  public QuestionnaireSearchResponse findByStartingTimeBetween(@RequestBody QuestionnaireSearchRequest questionnaireSearchRequest) {
    return questionnaireService.findByStartingTimeBetween(questionnaireSearchRequest);
  }

  @PostMapping(value = "findByStartingTimeGreaterThan")
  public QuestionnaireSearchResponse findByStartingTimeGreaterThan(@RequestBody QuestionnaireSearchRequest questionnaireSearchRequest) {
    return questionnaireService.findByStartingTimeGreaterThan(questionnaireSearchRequest);
  }

  @PostMapping(value = "findByEndTimeLessThan")
  public QuestionnaireSearchResponse findByEndTimeLessThan(@RequestBody QuestionnaireSearchRequest questionnaireSearchRequest) {
    return questionnaireService.findByEndTimeLessThan(questionnaireSearchRequest);
  }
}