package it.euris.centrosportivobm.service.impl;

import it.euris.centrosportivobm.data.model.Course;
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
  public Course save(Course course) {
    return courseRepository.save(course);
  }

  @Override
  public void deleteById(Long idCourse) {
    courseRepository.deleteById(idCourse);
  }

  @Override
  public Course findById(Long idCourse) {
    return courseRepository.findById(idCourse).orElse(Course.builder().build());
  }
}
