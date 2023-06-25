package com.example.questionnaire;

import com.example.questionnaire.repository.QuestionnaireContentDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class QuestionnaireContentTest {

  @Autowired
  QuestionnaireContentDao questionnaireContentDao;

  @Test
  public void findAllByQuestionnaireId(){
    System.out.println(questionnaireContentDao.findAllByQuestionnaireId(10).size());
    System.out.println("===============================");
  }
}
