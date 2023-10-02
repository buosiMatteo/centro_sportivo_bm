package it.euris.centrosportivobm.model;

import it.euris.centrosportivobm.dto.CustomerDTO;
import it.euris.centrosportivobm.dto.archetype.Dto;
import it.euris.centrosportivobm.dto.archetype.Model;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customer implements Model {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "birth_date")
  private LocalDateTime birthDate;

  @Column(name = "deleted")
  private Boolean deleted;

  @Column(name = "name")
  private String name;

  @Column(name = "surname")
  private String surname;

  @Column(name = "tax_code")
  private String taxCode;

  @Override
  public CustomerDTO toDto() {
    return CustomerDTO
        .builder()
        .birthDate(birthDate)
        .deleted(deleted)
        .name(name)
        .surname(surname)
        .taxCode(taxCode)
        .build();
  }
}
