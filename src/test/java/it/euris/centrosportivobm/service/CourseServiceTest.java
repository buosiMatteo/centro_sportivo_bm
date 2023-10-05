package it.euris.centrosportivobm.service;

import it.euris.centrosportivobm.data.model.Course;
import it.euris.centrosportivobm.exception.IdMustBeNullException;
import it.euris.centrosportivobm.exception.IdMustNotBeNullException;
import it.euris.centrosportivobm.repository.CourseRepository;
import it.euris.centrosportivobm.service.impl.CourseServiceImpl;
import it.euris.centrosportivobm.utility.TestSupport;
import org.assertj.core.api.recursive.comparison.ComparingSnakeOrCamelCaseFields;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CourseServiceTest {

  @Mock
  CourseRepository courseRepository;

  @InjectMocks
  CourseServiceImpl courseService;

  @Test
  void shouldReturnACourse(){

    Course course = TestSupport.getCourse(1L);

    List<Course> courses = List.of(course);

    when(courseRepository.findAll()).thenReturn(courses);

    List<Course> returnedCourses = courseService.findAll();

    assertThat(returnedCourses)
        .hasSize(1)
        .first()
        .usingRecursiveComparison()
        .withIntrospectionStrategy(new ComparingSnakeOrCamelCaseFields())
        .isEqualTo(course);
  }

  @Test
  void shouldInsertACourse(){

    Course course = TestSupport.getCourse(null);

    when(courseRepository.save(any())).thenReturn(course);

    Course returnedCustomer = courseService.insert(course);
    assertThat(returnedCustomer.getDenomination())
        .isEqualTo(course.getDenomination());
    assertThat(returnedCustomer.getPrice())
        .isEqualTo(course.getPrice());
  }

  @Test
  void shouldNotInsertAnyCourse(){

    Course course = TestSupport.getCourse(1L);
    lenient().when(courseRepository.save(any())).thenReturn(course);

    assertThrows(IdMustBeNullException.class, () -> courseService.insert(course));

    assertThatThrownBy(() -> courseService.insert(course))
        .isInstanceOf(IdMustBeNullException.class);

  }

  @Test
  void shouldUpdateACourse(){

    Course course = TestSupport.getCourse(1L);

    when(courseRepository.save(any())).thenReturn(course);

    Course returnedCourse = courseService.update(course);
    assertThat(returnedCourse.getDenomination())
        .isEqualTo(course.getDenomination());
  }

  @Test
  void shouldNotUpdateAnyCourse(){

    Course course = TestSupport.getCourse(null);
    lenient().when(courseRepository.save(any())).thenReturn(course);

    assertThatThrownBy(() -> courseService.update(course))
        .isInstanceOf(IdMustNotBeNullException.class);
  }

  @Test
  void shouldDeleteACourse() {
    //arrange
    Long id = 12L;

    doNothing().when(courseRepository).deleteById(anyLong());
    when(courseRepository.findById(id)).thenReturn(Optional.empty());
    assertTrue(courseService.deleteById(id));
    Mockito.verify(courseRepository, times(1)).deleteById(id);
  }

}