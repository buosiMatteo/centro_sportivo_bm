package it.euris.centrosportivobm.controller;

import it.euris.centrosportivobm.data.model.Customer;
import it.euris.centrosportivobm.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

  @Autowired
  MockMvc mockMvc;

  @MockBean
  CustomerService customerService;

  @Test
  public void shouldGetOneCustomer() throws Exception {
    Customer customer = Customer
        .builder()
        .birthDate(LocalDateTime.parse("1970-03-25T12:12:00.456"))
        .deleted(false)
        .name("Mario")
        .surname("Rossi")
        .taxCode("Standard")
        .build();

    List<Customer> customers = List.of(customer);

    when(customerService.findAll()).thenReturn(customers);

    mockMvc.perform(MockMvcRequestBuilders.get("/customers/v1"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON));

  }

  @Test
  public void shouldGetCustomersById() throws Exception {
    Long idCustomer = 1L;

    Customer customer = Customer
        .builder()
        .birthDate(LocalDateTime.parse("1980-06-05T16:13:18.373"))
        .deleted(false)
        .name("Anna")
        .surname("Neri")
        .taxCode("Standard")
        .build();

    when(customerService.findById(idCustomer)).thenReturn(customer);

    mockMvc.perform(MockMvcRequestBuilders.get("/customers/v1/{id}",idCustomer))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON));
  }
}