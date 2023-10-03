package it.euris.centrosportivobm.data.dto;

import it.euris.centrosportivobm.data.dto.archetype.Dto;
import it.euris.centrosportivobm.data.model.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static it.euris.centrosportivobm.utility.DataConversionUnit.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO  implements Dto {
  private String id;

  private String address;

  private String city;

  private String deleted;

  private String nation;

  private String postalCode;

  private String province;

  @Override
  public Address toModel() {
    return Address
        .builder()
        .id(stringToLong(id))
        .address(address)
        .city(city)
        .deleted(stringToBoolean(deleted))
        .nation(nation)
        .postalCode(stringToInteger(postalCode))
        .province(province)
        .build();
  }
}
