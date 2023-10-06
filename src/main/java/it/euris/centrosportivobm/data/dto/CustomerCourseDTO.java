package it.euris.centrosportivobm.data.dto;

import it.euris.centrosportivobm.data.dto.archetype.Dto;
import it.euris.centrosportivobm.data.model.Course;
import it.euris.centrosportivobm.data.model.Customer;
import it.euris.centrosportivobm.data.model.CustomerCourse;
import it.euris.centrosportivobm.data.model.key.CourseCustomerKey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static it.euris.centrosportivobm.utility.DataConversionUnit.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerCourseDTO implements Dto {

  private String courseId;

  private String customerId;

  private String deleted;

  @Override
  public CustomerCourse toModel() {
    return CustomerCourse
        .builder()
        .id(new CourseCustomerKey(stringToLong(courseId),stringToLong(customerId)))
        .course(Course.builder().id(stringToLong(courseId)).build())
        .customer(Customer.builder().id(stringToLong(customerId)).build())
        .deleted(stringToBoolean(deleted))
        .build();
  }
}
