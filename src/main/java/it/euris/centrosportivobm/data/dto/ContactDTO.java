package it.euris.centrosportivobm.data.dto;

import it.euris.centrosportivobm.data.dto.archetype.Dto;
import it.euris.centrosportivobm.data.model.Contact;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static it.euris.centrosportivobm.utility.DataConversionUnit.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactDTO implements Dto {

  private String id;

  private String contactType;

  private String deleted;

  private String value;

  @Override
  public Contact toModel() {
    return Contact
        .builder()
        .id(stringToLong(id))
        .contactType(contactType)
        .deleted(stringToBoolean(deleted))
        .value(value)
        .build();
  }
}
