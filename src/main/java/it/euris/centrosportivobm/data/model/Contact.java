package it.euris.centrosportivobm.data.model;

import it.euris.centrosportivobm.data.dto.ContactDTO;
import it.euris.centrosportivobm.data.dto.archetype.Model;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import static it.euris.centrosportivobm.utility.DataConversionUnit.booleanToString;
import static it.euris.centrosportivobm.utility.DataConversionUnit.numberToString;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contact")
@SQLDelete(sql = "UPDATE contact SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class Contact implements Model {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "contact_type")
  private String contactType;

  @Builder.Default
  @Column(name = "deleted")
  private Boolean deleted = false;

  @Column(name = "value")
  private String value;

  @ManyToOne
  @JoinColumn(name = "customer_id")
  Customer customer;

  @Override
  public ContactDTO toDto() {
    return ContactDTO
        .builder()
        .id(numberToString(id))
        .contactType(contactType)
        .deleted(booleanToString(deleted))
        .value(value)
        .build();
  }
}
