package it.euris.centrosportivobm.repository;

import it.euris.centrosportivobm.data.model.CustomerCourse;
import it.euris.centrosportivobm.data.model.key.CustomerCourseKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerCourseRepository extends JpaRepository<CustomerCourse, CustomerCourseKey> {

}
