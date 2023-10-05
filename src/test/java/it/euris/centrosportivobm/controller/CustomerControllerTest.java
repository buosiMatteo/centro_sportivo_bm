package it.euris.centrosportivobm.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.euris.centrosportivobm.config.security.SecurityConf;
import it.euris.centrosportivobm.data.model.Customer;
import it.euris.centrosportivobm.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Import(value = { SecurityConf.class })
class CustomerControllerTest {

  @Autowired
  MockMvc mockMvc;

  @MockBean
  CustomerService customerService;
  @Autowired
  ObjectMapper objectMapper;

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
        .id(idCustomer)
        .birthDate(LocalDateTime.parse("1980-06-05T16:13:18.373"))
        .deleted(false)
        .name("Anna")
        .surname("Neri")
        .taxCode("Standard")
        .build();

    when(customerService.findById(idCustomer)).thenReturn(customer);

    String auth = Base64.getEncoder().encodeToString(("admin:admin").getBytes());

    mockMvc.perform(MockMvcRequestBuilders.get("/customers/v1/{id}",idCustomer)
            .header(HttpHeaders.AUTHORIZATION, "Basic " + auth)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(customer.toDto())))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
  }
}