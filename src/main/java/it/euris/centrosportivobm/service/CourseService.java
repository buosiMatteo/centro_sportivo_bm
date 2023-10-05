package it.euris.centrosportivobm.service;

import it.euris.centrosportivobm.data.model.Course;

import java.util.List;

public interface CourseService {
  List<Course> findAll();

  Course insert(Course course);

  Course update(Course course);

  Boolean deleteById(Long idCourse);

  Course findById(Long idCourse);


}
