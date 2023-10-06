package it.euris.centrosportivobm.data.model;

import it.euris.centrosportivobm.data.dto.CustomerCourseDTO;
import it.euris.centrosportivobm.data.dto.archetype.Model;
import it.euris.centrosportivobm.data.model.key.CourseCustomerKey;
import jakarta.persistence.*;
import lombok.*;

import static it.euris.centrosportivobm.utility.DataConversionUnit.booleanToString;
import static it.euris.centrosportivobm.utility.DataConversionUnit.customerCourseKeyToString;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer_course")
public class CustomerCourse implements Model {

  @EmbeddedId
  private CourseCustomerKey id;

  @ManyToOne
  @MapsId("courseId")
  @JoinColumn(name = "course_id")
  private Course course;

  @ManyToOne
  @MapsId("customerId")
  @JoinColumn(name = "customer_id")
  private Customer customer;

  @Column(name = "deleted")
  private Boolean deleted;

  @Override
  public CustomerCourseDTO toDto() {
    return CustomerCourseDTO
        .builder()
        .courseId(course == null ? null : course.getId().toString())
        .customerId(customer == null ? null : customer.getId().toString())
        .deleted(booleanToString(deleted))
        .build();
  }
}
