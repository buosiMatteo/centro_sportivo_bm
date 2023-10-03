package it.euris.centrosportivobm.service;

import it.euris.centrosportivobm.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseServiceTest {

  @MockBean
  CourseRepository courseRepository;

  @Autowired
  CourseService courseService;

}