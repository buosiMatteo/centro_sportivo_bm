package it.euris.centrosportivobm.data.dto;

import it.euris.centrosportivobm.data.dto.archetype.Dto;
import it.euris.centrosportivobm.data.model.Address;
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
        .id(id)
        .address(address)
        .city(city)
        .deleted(deleted)
        .nation(nation)
        .postalCode(postalCode)
        .province(province)
        .build();
  }
}
