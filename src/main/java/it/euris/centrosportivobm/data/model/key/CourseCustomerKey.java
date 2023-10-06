package it.euris.centrosportivobm.data.model.key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
@Embeddable
public class CourseCustomerKey implements Serializable {

  public CourseCustomerKey(Long courseId, Long customerId) {
    this.courseId = courseId;
    this.customerId = customerId;
  }

  @Column(name = "course_id")
  private Long courseId;

  @Column(name = "customer_id")
  private Long customerId;
}
