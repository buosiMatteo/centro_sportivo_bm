package it.euris.centrosportivobm.dto;

import it.euris.centrosportivobm.dto.archetype.Dto;
import it.euris.centrosportivobm.dto.archetype.Model;
import it.euris.centrosportivobm.model.Contact;
import it.euris.centrosportivobm.model.Customer;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
        .contactType(contactType)
        .deleted(deleted)
        .value(value)
        .build();
  }
}
