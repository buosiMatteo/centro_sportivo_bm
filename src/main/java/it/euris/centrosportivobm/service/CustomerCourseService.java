package it.euris.centrosportivobm.service;

import it.euris.centrosportivobm.data.model.Course;
import it.euris.centrosportivobm.data.model.CustomerCourse;
import it.euris.centrosportivobm.data.model.key.CustomerCourseKey;
import it.euris.centrosportivobm.repository.CustomerCourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CustomerCourseService {

  List<CustomerCourse> findAll();

  CustomerCourse save(CustomerCourse customerCourse);

  void deleteById(CustomerCourseKey idCustomerCourse);

  CustomerCourse findById(CustomerCourseKey idCustomerCourse);

}
