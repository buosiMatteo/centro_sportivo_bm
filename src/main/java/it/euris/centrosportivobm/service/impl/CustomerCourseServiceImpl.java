package it.euris.centrosportivobm.service.impl;

import it.euris.centrosportivobm.data.model.CustomerCourse;
import it.euris.centrosportivobm.data.model.key.CourseCustomerKey;
import it.euris.centrosportivobm.exception.IdMustBeNullException;
import it.euris.centrosportivobm.exception.IdMustNotBeNullException;
import it.euris.centrosportivobm.repository.CustomerCourseRepository;
import it.euris.centrosportivobm.service.CustomerCourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerCourseServiceImpl implements CustomerCourseService {

  CustomerCourseRepository customerCourseRepository;

  @Override
  public List<CustomerCourse> findAll() {
    return customerCourseRepository.findAll();
  }

  @Override
  public CustomerCourse insert(CustomerCourse customerCourse) {
    if (customerCourse.getId().getCourseId() == null ||
        customerCourse.getId().getCustomerId() == null) {
      throw new IdMustNotBeNullException();
    }
    return customerCourseRepository.save(customerCourse);
  }

  @Override
  public CustomerCourse update(CustomerCourse customerCourse) {
    if (customerCourse.getId() == null){
      throw new IdMustNotBeNullException();
    }
    return customerCourseRepository.save(customerCourse);
  }

  @Override
  public Boolean deleteById(CourseCustomerKey courseCustomerId) {
    customerCourseRepository.deleteById(courseCustomerId);
    return customerCourseRepository.findById(courseCustomerId).isEmpty();
  }

  @Override
  public CustomerCourse findById(CourseCustomerKey courseCustomerId) {
    return customerCourseRepository.findById(courseCustomerId).orElse(CustomerCourse.builder().build());
  }
}
