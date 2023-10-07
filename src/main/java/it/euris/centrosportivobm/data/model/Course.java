package it.euris.centrosportivobm.data.model;

import it.euris.centrosportivobm.data.dto.CourseDTO;
import it.euris.centrosportivobm.data.dto.archetype.Model;
import it.euris.centrosportivobm.data.enums.SportType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import static it.euris.centrosportivobm.utility.DataConversionUnit.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "course")
@SQLDelete(sql = "UPDATE course SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class Course implements Model {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Builder.Default
  @Column(name = "deleted")
  private Boolean deleted = false;

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
        .id(numberToString(id))
        .deleted(booleanToString(deleted))
        .denomination(denomination)
        .difficulty(difficulty)
        .price(numberToString(price))
        .sport(sportTypeToString(sport))
        .build();
  }
}
