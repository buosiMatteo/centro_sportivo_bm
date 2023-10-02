package it.euris.centrosportivobm.service;

import it.euris.centrosportivobm.model.Course;
import it.euris.centrosportivobm.model.Customer;

import java.util.List;

public interface CourseService {
  List<Course> findAll();

  Course save(Course course);

  void deleteById(Long idCourse);

  Course findById(Long idCourse);
}
