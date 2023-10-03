package it.euris.centrosportivobm.service.impl;

import it.euris.centrosportivobm.data.dto.CustomerDTO;
import it.euris.centrosportivobm.data.model.CustomerCourse;
import it.euris.centrosportivobm.data.model.key.CustomerCourseKey;
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
  public CustomerCourse save(CustomerCourse customerCourse) {
    return customerCourseRepository.save(customerCourse);
  }

  @Override
  public void deleteById(CustomerCourseKey idCustomerCourse) {
    customerCourseRepository.deleteById(idCustomerCourse);
  }

  @Override
  public CustomerCourse findById(CustomerCourseKey idCustomerCourse) {
    return customerCourseRepository.findById(idCustomerCourse).orElse(CustomerCourse.builder().build());
  }
}
