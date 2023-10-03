package it.euris.centrosportivobm.data.dto;

import it.euris.centrosportivobm.data.dto.archetype.Dto;
import it.euris.centrosportivobm.data.enums.SportType;
import it.euris.centrosportivobm.data.model.Course;
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

  private SportType sport;

  @Override
  public Course toModel() {
    return Course
        .builder()
        .id(id)
        .deleted(deleted)
        .denomination(denomination)
        .difficulty(difficulty)
        .price(price)
        .sport(sport)
        .build();
  }
}
