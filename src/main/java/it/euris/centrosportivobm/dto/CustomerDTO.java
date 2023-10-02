package it.euris.centrosportivobm.dto;

import it.euris.centrosportivobm.dto.archetype.Dto;
import it.euris.centrosportivobm.dto.archetype.Model;
import it.euris.centrosportivobm.model.Customer;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO implements Dto {

  private Long id;

  private LocalDateTime birthDate;

  private Boolean deleted;

  private String name;

  private String surname;

  private String taxCode;

  @Override
  public Customer toModel() {
    return Customer
        .builder()
        .id(id)
        .birthDate(birthDate)
        .deleted(deleted)
        .name(name)
        .surname(surname)
        .taxCode(taxCode)
        .build();
  }
}
