package it.euris.centrosportivobm.controller;

import it.euris.centrosportivobm.data.enums.SportType;
import it.euris.centrosportivobm.data.model.Course;
import it.euris.centrosportivobm.service.CourseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CourseController.class)
class CourseControllerTest {

  @Autowired
  MockMvc mockMvc;

  @MockBean
  CourseService courseService;

  @Test
  public void shouldGetOneCourse() throws Exception {

    Course course = Course
        .builder()
        .deleted(false)
        .denomination("Squad game")
        .difficulty("Medium")
        .price(80.00)
        .sport(SportType.BASKET)
        .build();

    List<Course> courses = List.of(course);

    when(courseService.findAll()).thenReturn(courses);

    mockMvc.perform(MockMvcRequestBuilders.get("/courses/v1"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$").isArray());
  }

}