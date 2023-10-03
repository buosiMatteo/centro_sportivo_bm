package it.euris.centrosportivobm.data.dto;

import it.euris.centrosportivobm.data.dto.archetype.Dto;
import it.euris.centrosportivobm.data.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static it.euris.centrosportivobm.utility.DataConversionUnit.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO implements Dto {

  private String id;

  private String birthDate;

  private String deleted;

  private String name;

  private String surname;

  private String taxCode;

  @Override
  public Customer toModel() {
    return Customer
        .builder()
        .id(stringToLong(id))
        .birthDate(stringToLocalDateTime(birthDate))
        .deleted(stringToBoolean(deleted))
        .name(name)
        .surname(surname)
        .taxCode(taxCode)
        .build();
  }
}
