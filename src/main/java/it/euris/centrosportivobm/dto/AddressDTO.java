package it.euris.centrosportivobm.dto;

import it.euris.centrosportivobm.dto.archetype.Dto;
import it.euris.centrosportivobm.dto.archetype.Model;
import it.euris.centrosportivobm.model.Address;
import it.euris.centrosportivobm.model.Customer;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO  implements Dto {
  private Long id;

  private String address;

  private String city;

  private Boolean deleted;

  private String nation;

  private Integer postalCode;

  private String province;

  @Override
  public Address toModel() {
    return Address
        .builder()
        .address(address)
        .city(city)
        .deleted(deleted)
        .nation(nation)
        .postalCode(postalCode)
        .province(province)
        .build();
  }
}
