package it.euris.centrosportivobm.utility;

import it.euris.centrosportivobm.data.enums.SportType;
import it.euris.centrosportivobm.data.model.Address;
import it.euris.centrosportivobm.data.model.Course;
import it.euris.centrosportivobm.data.model.Customer;

import java.time.LocalDateTime;

public class TestSupport {

  public static Course getCourse(Long id){
    return Course
        .builder()
        .id(id)
        .deleted(false)
        .denomination("Test denomination")
        .difficulty("Test")
        .price(50.00)
        .sport(SportType.CALCIO)
        .build();
  }

  public static Customer getCustomer(Long id) {
    return Customer
        .builder()
        .id(id)
        .birthDate(LocalDateTime.now())
        .deleted(false)
        .name("Test name")
        .surname("Test surname")
        .taxCode("Test tax code")
        .build();
  }

  public static Address getAddress(long id) {
    return Address
        .builder()
        .address("Via Roma 17")
        .city("Milano")
        .deleted(false)
        .nation("Italy")
        .postalCode(20061)
        .province("MI")
        .build();
  }
}
