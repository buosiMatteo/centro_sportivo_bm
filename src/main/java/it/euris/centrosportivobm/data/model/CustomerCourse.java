package it.euris.centrosportivobm.data.model;

import it.euris.centrosportivobm.data.dto.CustomerCourseDTO;
import it.euris.centrosportivobm.data.dto.archetype.Dto;
import it.euris.centrosportivobm.data.dto.archetype.Model;
import it.euris.centrosportivobm.data.model.key.CustomerCourseKey;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer_course")
public class CustomerCourse implements Model {

  @EmbeddedId
  private CustomerCourseKey id;

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
        .id(id)
        .deleted(deleted)
        .build();
  }
}
