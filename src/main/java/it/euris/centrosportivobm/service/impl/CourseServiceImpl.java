package it.euris.centrosportivobm.service.impl;

import it.euris.centrosportivobm.data.model.Course;
import it.euris.centrosportivobm.exception.IdMustBeNullException;
import it.euris.centrosportivobm.exception.IdMustNotBeNullException;
import it.euris.centrosportivobm.repository.CourseRepository;
import it.euris.centrosportivobm.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {

  CourseRepository courseRepository;

  @Override
  public List<Course> findAll() {
    return courseRepository.findAll();
  }

  @Override
  public Course insert(Course course) {
    if (course.getId() != null) {
      throw new IdMustBeNullException();
    }
    return courseRepository.save(course);
  }

  @Override
  public Course update(Course course) {
    if (course.getId() == null) {
      throw new IdMustNotBeNullException();
    }
    return courseRepository.save(course);
  }

  @Override
  public Boolean deleteById(Long idCourse) {
    courseRepository.deleteById(idCourse);
    return courseRepository.findById(idCourse).isEmpty();
  }

  @Override
  public Course findById(Long idCourse) {
    return courseRepository.findById(idCourse).orElse(Course.builder().build());
  }

}
