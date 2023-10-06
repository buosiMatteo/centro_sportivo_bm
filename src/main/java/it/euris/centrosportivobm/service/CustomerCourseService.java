package it.euris.centrosportivobm.service;

import it.euris.centrosportivobm.data.model.CustomerCourse;
import it.euris.centrosportivobm.data.model.key.CourseCustomerKey;

import java.util.List;


public interface CustomerCourseService {

  List<CustomerCourse> findAll();

  CustomerCourse insert(CustomerCourse customerCourse);

  CustomerCourse update(CustomerCourse customerCourse);

  Boolean deleteById(CourseCustomerKey courseCustomertId);

  CustomerCourse findById(CourseCustomerKey courseCustomertId);

}
