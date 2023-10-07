package it.euris.centrosportivobm.data.model;

import it.euris.centrosportivobm.data.dto.CustomerDTO;
import it.euris.centrosportivobm.data.dto.archetype.Model;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;

import static it.euris.centrosportivobm.utility.DataConversionUnit.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
@SQLDelete(sql = "UPDATE customer SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class Customer implements Model {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "birth_date")
  private LocalDateTime birthDate;

  @Builder.Default
  @Column(name = "deleted")
  private Boolean deleted = false;

  @Column(name = "name")
  private String name;

  @Column(name = "surname")
  private String surname;

  @Column(name = "tax_code")
  private String taxCode;

  @Override
  public CustomerDTO toDto() {
    return CustomerDTO
        .builder()
        .id(numberToString(id))
        .birthDate(localDateTimeToString(birthDate))
        .deleted(booleanToString(deleted))
        .name(name)
        .surname(surname)
        .taxCode(taxCode)
        .build();
  }
}
