package it.euris.centrosportivobm.data.model;

import it.euris.centrosportivobm.data.dto.AddressDTO;
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
@Table(name = "address")
@SQLDelete(sql = "UPDATE address SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class Address implements Model {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "address")
  private String address;

  @Column(name = "city")
  private String city;

  @Builder.Default
  @Column(name = "deleted")
  private Boolean deleted = false;

  @Column(name = "nation")
  private String nation;

  @Column(name = "postal_code")
  private Integer postalCode;

  @Column(name = "province")
  private String province;

  @OneToOne
  @JoinColumn(name = "customer_id")
  private Customer customer;

  @Override
  public AddressDTO toDto() {
    return AddressDTO
        .builder()
        .id(numberToString(id))
        .address(address)
        .city(city)
        .deleted(booleanToString(deleted))
        .nation(nation)
        .postalCode(numberToString(postalCode))
        .province(province)
        .build();
  }
}
