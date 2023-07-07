package com.example.questionnaire.controller;

import com.example.questionnaire.service.ifs.*;
import com.example.questionnaire.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class QuestionnaireBackstageController {

  @Autowired
  QuestionnaireService questionnaireService;

  @Autowired
  QuestionnaireContentService questionnaireContentService;

  @Autowired
  UserService userService;

  @Autowired
  AnswerContentService answerContentService;

  @Autowired
  AnswerRecordService answerRecordService;

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

  @PostMapping(value = "findByQuestionnaireFuzzySearchAndStartingTimeThanEqual")
  public QuestionnaireResponse findByQuestionnaireFuzzySearchAndStartingTimeThanEqual(@RequestBody QuestionnaireSearchRequest questionnaireSearchRequest) {
    return questionnaireService.findByQuestionnaireFuzzySearchAndStartingTimeThanEqual(questionnaireSearchRequest);
  }

  @PostMapping(value = "findByQuestionnaireFuzzySearchAndEndTimeLessThanEqual")
  public QuestionnaireResponse findByQuestionnaireFuzzySearchAndEndTimeLessThanEqual(@RequestBody QuestionnaireSearchRequest questionnaireSearchRequest) {
    return questionnaireService.findByQuestionnaireFuzzySearchAndEndTimeLessThanEqual(questionnaireSearchRequest);
  }

  @PostMapping(value = "findByQuestionnaireFuzzySearchStartingTimeThanEqualAndEndTimeLessThanEqual")
  public QuestionnaireResponse findByQuestionnaireFuzzySearchStartingTimeThanEqualAndEndTimeLessThanEqual(@RequestBody QuestionnaireSearchRequest questionnaireSearchRequest) {
    return questionnaireService.findByQuestionnaireFuzzySearchStartingTimeThanEqualAndEndTimeLessThanEqual(questionnaireSearchRequest);
  }


  //  ====================QuestionnaireContent====================

  @PostMapping(value = "addQuestionnaireContent")
  public QuestionnaireContentResponse addQuestionnaireContent(@RequestBody QuestionnaireContentRequest questionnaireContentRequest) {
    return questionnaireContentService.addQuestionnaireContent(questionnaireContentRequest);
  }

  @PostMapping(value = "deleteQuestionnaireContent")
  public QuestionnaireContentResponse deleteQuestionnaireContent(@RequestBody QuestionnaireContentRequest questionnaireContentRequest) {
    return questionnaireContentService.deleteQuestionnaireContent(questionnaireContentRequest);
  }

  @PostMapping(value = "modifyQuestionnaireContent")
  public QuestionnaireContentResponse modifyQuestionnaireContent(@RequestBody QuestionnaireContentRequest questionnaireContentRequest) {
    return questionnaireContentService.modifyQuestionnaireContent(questionnaireContentRequest);
  }

  @PostMapping(value = "findAllByQuestionnaireId")
  public QuestionnaireContentResponse findAllByQuestionnaireId(@RequestBody QuestionnaireContentRequest questionnaireContentRequest) {
    return questionnaireContentService.findAllByQuestionnaireId(questionnaireContentRequest);
  }

  @PostMapping(value = "findByQuestionnaireContentId")
  public QuestionnaireContentResponse findByQuestionnaireContentId(@RequestBody QuestionnaireContentRequest questionnaireContentRequest) {
    return questionnaireContentService.findByQuestionnaireContentId(questionnaireContentRequest);
  }

  //  ====================User====================

  @PostMapping(value = "addUser")
  public UserResponse addUser(@RequestBody UserRequest userRequest) {
    return userService.addUser(userRequest);
  }

  @PostMapping(value = "deleteUser")
  public UserResponse deleteUser(@RequestBody UserRequest userRequest) {
    return userService.deleteUser(userRequest);
  }

  @PostMapping(value = "findByUserId")
  public UserResponse findByUserId(@RequestBody UserRequest userRequest) {
    return userService.findByUserId(userRequest);
  }

  //  ====================AnswerContent====================

  @PostMapping(value = "addAnswerContent")
  public AnswerContentResponse addAnswerContent(@RequestBody AnswerContentRequest answerContentRequest) {
    return answerContentService.addAnswerContent(answerContentRequest);
  }

  @PostMapping(value = "deleteAnswerContent")
  public AnswerContentResponse deleteAnswerContent(@RequestBody AnswerContentRequest answerContentRequest) {
    return answerContentService.deleteAnswerContent (answerContentRequest);
  }

  @PostMapping(value = "findByAnswerContentId")
  public AnswerContentResponse  findByAnswerContentId(@RequestBody AnswerContentRequest answerContentRequest) {
    return answerContentService.findByAnswerContentId (answerContentRequest);
  }

  @PostMapping(value = "findByQuestionnaireIdFromAnswerContent")
  public AnswerContentResponse findByQuestionnaireIdFromAnswerContent(@RequestBody AnswerContentRequest answerContentRequest) {
    return answerContentService.findByQuestionnaireIdFromAnswerContent (answerContentRequest);
  }

  @PostMapping(value = "findByUserIdAndQuestionnaireId")
  public AnswerContentResponse  findByUserIdAndQuestionnaireId(@RequestBody AnswerContentRequest answerContentRequest) {
    return answerContentService.findByUserIdAndQuestionnaireId (answerContentRequest);
  }

  //  ====================AnswerRecord====================

  @PostMapping(value = "addAnswerRecord")
  public AnswerRecordResponse addAnswerRecord(@RequestBody AnswerRecordRequest answerRecordRequest){
    return answerRecordService.addAnswerRecord(answerRecordRequest);
  }

  @PostMapping(value = "deleteAnswerRecord")
  public AnswerRecordResponse deleteAnswerRecord(@RequestBody AnswerRecordRequest answerRecordRequest){
    return answerRecordService.deleteAnswerRecord(answerRecordRequest);
  }

  @PostMapping(value = "findByAnswerRecordId")
  public AnswerRecordResponse findByAnswerRecordId(@RequestBody AnswerRecordRequest answerRecordRequest){
    return answerRecordService.findByAnswerRecordId(answerRecordRequest);
  }

  @PostMapping(value = "findAllByQuestionnaireIdFromAnswerRecordOrder")
  public AnswerRecordResponse findAllByQuestionnaireIdFromAnswerRecordOrder(@RequestBody AnswerRecordRequest answerRecordRequest){
    return answerRecordService.findAllByQuestionnaireIdFromAnswerRecordOrder(answerRecordRequest);
  }
}