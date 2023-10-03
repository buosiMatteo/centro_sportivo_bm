package it.euris.centrosportivobm.data.dto;

import it.euris.centrosportivobm.data.dto.archetype.Dto;
import it.euris.centrosportivobm.data.model.Course;
import it.euris.centrosportivobm.data.model.Customer;
import it.euris.centrosportivobm.data.model.CustomerCourse;
import it.euris.centrosportivobm.data.model.key.CustomerCourseKey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerCourseDTO implements Dto {

  private CustomerCourseKey id;
  private Course course;
  private Customer customer;
  private Boolean deleted;

  @Override
  public CustomerCourse toModel() {
    return CustomerCourse
        .builder()
        .id(id)
        .deleted(deleted)
        .build();
  }
}
