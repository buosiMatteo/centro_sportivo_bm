package it.euris.centrosportivobm.repository;

import it.euris.centrosportivobm.data.model.CustomerCourse;
import it.euris.centrosportivobm.data.model.key.CourseCustomerKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerCourseRepository extends JpaRepository<CustomerCourse, CourseCustomerKey> {

}
