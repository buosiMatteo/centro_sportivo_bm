package it.euris.centrosportivobm.data.dto;

import it.euris.centrosportivobm.data.dto.archetype.Dto;
import it.euris.centrosportivobm.data.enums.SportType;
import it.euris.centrosportivobm.data.model.Course;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static it.euris.centrosportivobm.utility.DataConversionUnit.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO implements Dto {

  private String id;

  private String deleted;

  private String denomination;

  private String difficulty;

  private String price;

  private String sport;

  @Override
  public Course toModel() {
    return Course
        .builder()
        .id(stringToLong(id))
        .deleted(stringToBoolean(deleted))
        .denomination(denomination)
        .difficulty(difficulty)
        .price(stringToDouble(price))
        .sport(stringToSportType(sport))
        .build();
  }
}
