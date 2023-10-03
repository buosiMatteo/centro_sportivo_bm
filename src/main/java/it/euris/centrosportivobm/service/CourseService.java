package it.euris.centrosportivobm.service;

import it.euris.centrosportivobm.data.model.Course;

import java.util.List;

public interface CourseService {
  List<Course> findAll();

  Course save(Course course);

  void deleteById(Long idCourse);

  Course findById(Long idCourse);
}
