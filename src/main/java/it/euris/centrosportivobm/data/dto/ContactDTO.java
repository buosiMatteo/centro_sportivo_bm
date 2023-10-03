package it.euris.centrosportivobm.data.dto;

import it.euris.centrosportivobm.data.dto.archetype.Dto;
import it.euris.centrosportivobm.data.model.Contact;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactDTO implements Dto {

  private Long id;

  private String contactType;

  private Boolean deleted;

  private String value;

  @Override
  public Contact toModel() {
    return Contact
        .builder()
        .id(id)
        .contactType(contactType)
        .deleted(deleted)
        .value(value)
        .build();
  }
}
