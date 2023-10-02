package it.euris.centrosportivobm.model;

import it.euris.centrosportivobm.dto.CourseDTO;
import it.euris.centrosportivobm.dto.archetype.Dto;
import it.euris.centrosportivobm.dto.archetype.Model;
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
  private String sport;

  @Override
  public CourseDTO toDto() {
    return CourseDTO
        .builder()
        .deleted(deleted)
        .denomination(denomination)
        .difficulty(difficulty)
        .price(price)
        .sport(sport)
        .build();
  }
}
