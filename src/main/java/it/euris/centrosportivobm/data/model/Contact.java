package it.euris.centrosportivobm.data.model;

import it.euris.centrosportivobm.data.dto.ContactDTO;
import it.euris.centrosportivobm.data.dto.archetype.Model;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contact")
public class Contact implements Model {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "contact_type")
  private String contactType;

  @Column(name = "deleted")
  private Boolean deleted;

  @Column(name = "value")
  private String value;

  @ManyToOne
  @JoinColumn(name = "customer_id")
  Customer customer;

  @Override
  public ContactDTO toDto() {
    return ContactDTO
        .builder()
        .id(id)
        .contactType(contactType)
        .deleted(deleted)
        .value(value)
        .build();
  }
}
