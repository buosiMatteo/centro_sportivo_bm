package it.euris.centrosportivobm.data.model;

import it.euris.centrosportivobm.data.dto.CourseDTO;
import it.euris.centrosportivobm.data.dto.archetype.Model;
import it.euris.centrosportivobm.data.enums.SportType;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "course")
public class Course implements Model {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "deleted")
  private Boolean deleted;

  @Column(name = "denomination")
  private String denomination;

  @Column(name = "difficulty")
  private String difficulty;

  @Column(name = "price")
  private Double price;

  @Column(name = "sport")
  @Enumerated(EnumType.STRING)
  private SportType sport;

  @Override
  public CourseDTO toDto() {
    return CourseDTO
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
