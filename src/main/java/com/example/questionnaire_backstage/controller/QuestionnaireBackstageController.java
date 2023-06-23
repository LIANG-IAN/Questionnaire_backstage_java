package com.example.questionnaire_backstage.controller;

import com.example.questionnaire_backstage.service.ifs.QuestionnaireContentService;
import com.example.questionnaire_backstage.service.ifs.QuestionnaireService;
import com.example.questionnaire_backstage.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class QuestionnaireBackstageController {

  @Autowired
  QuestionnaireService questionnaireService;

  @Autowired
  QuestionnaireContentService questionnaireContentService;

  //  ====================Questionnaire====================

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

  @PostMapping(value = "findByQuestionnaireId")
  public QuestionnaireResponse findByQuestionnaireId(@RequestBody QuestionnaireRequest questionnaireRequest) {
    return questionnaireService.findByQuestionnaireId(questionnaireRequest);
  }

  @GetMapping(value = "findAll")
  public QuestionnaireResponse findAll() {
    return questionnaireService.findAll();
  }

  @PostMapping(value = "findByQuestionnaireFuzzySearch")
  public QuestionnaireResponse findByQuestionnaireFuzzySearch(@RequestBody QuestionnaireSearchRequest questionnaireSearchRequest) {
    return questionnaireService.findByQuestionnaireFuzzySearch(questionnaireSearchRequest);
  }

  @PostMapping(value = "findByStartingTime")
  public QuestionnaireResponse findByStartingTime(@RequestBody QuestionnaireSearchRequest questionnaireSearchRequest) {
    return questionnaireService.findByStartingTime(questionnaireSearchRequest);
  }

  @PostMapping(value = "findByEndTime")
  public QuestionnaireResponse findByEndTime(@RequestBody QuestionnaireSearchRequest questionnaireSearchRequest) {
    return questionnaireService.findByEndTime(questionnaireSearchRequest);
  }

  @PostMapping(value = "findByStartingTimeBetween")
  public QuestionnaireResponse findByStartingTimeBetween(@RequestBody QuestionnaireSearchRequest questionnaireSearchRequest) {
    return questionnaireService.findByStartingTimeBetween(questionnaireSearchRequest);
  }

  @PostMapping(value = "findByStartingTimeGreaterThan")
  public QuestionnaireResponse findByStartingTimeGreaterThan(@RequestBody QuestionnaireSearchRequest questionnaireSearchRequest) {
    return questionnaireService.findByStartingTimeGreaterThan(questionnaireSearchRequest);
  }

  @PostMapping(value = "findByEndTimeLessThan")
  public QuestionnaireResponse findByEndTimeLessThan(@RequestBody QuestionnaireSearchRequest questionnaireSearchRequest) {
    return questionnaireService.findByEndTimeLessThan(questionnaireSearchRequest);
  }

  //  ====================QuestionnaireContent====================

  @PostMapping(value = "addQuestionnaireContent")
  public QuestionnaireContentResponse addQuestionnaireContent(@RequestBody QuestionnaireContentRequest questionnaireContentRequest){
    return questionnaireContentService.addQuestionnaireContent(questionnaireContentRequest);
  }

  @PostMapping(value = "deleteQuestionnaireContent")
  public QuestionnaireContentResponse deleteQuestionnaireContent(@RequestBody QuestionnaireContentRequest questionnaireContentRequest){
    return questionnaireContentService.deleteQuestionnaireContent(questionnaireContentRequest);
  }

  @PostMapping(value = "modifyQuestionnaireContent")
  public QuestionnaireContentResponse modifyQuestionnaireContent(@RequestBody QuestionnaireContentRequest questionnaireContentRequest){
    return questionnaireContentService.modifyQuestionnaireContent(questionnaireContentRequest);
  }

  @PostMapping(value = "findAllByQuestionnaireId")
  public QuestionnaireContentResponse findAllByQuestionnaireId(@RequestBody QuestionnaireContentRequest questionnaireContentRequest){
    return questionnaireContentService.findAllByQuestionnaireId(questionnaireContentRequest);
  }

  @PostMapping(value = "findById")
  public QuestionnaireContentResponse findById(@RequestBody QuestionnaireContentRequest questionnaireContentRequest){
    return questionnaireContentService.findById(questionnaireContentRequest);
  }
}