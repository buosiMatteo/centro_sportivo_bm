package it.euris.centrosportivobm.dto;

import it.euris.centrosportivobm.dto.archetype.Dto;
import it.euris.centrosportivobm.dto.archetype.Model;
import it.euris.centrosportivobm.model.Course;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO implements Dto {

  private Long id;

  private Boolean deleted;

  private String denomination;

  private String difficulty;

  private Double price;

  private String sport;

  @Override
  public Course toModel() {
    return Course
        .builder()
        .deleted(deleted)
        .denomination(denomination)
        .difficulty(difficulty)
        .price(price)
        .sport(sport)
        .build();
  }
}
