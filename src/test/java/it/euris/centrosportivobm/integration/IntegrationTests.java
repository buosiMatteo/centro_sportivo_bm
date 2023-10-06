package it.euris.centrosportivobm.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.euris.centrosportivobm.config.security.SecurityConf;
import it.euris.centrosportivobm.data.dto.CustomerDTO;
import it.euris.centrosportivobm.utility.TestSupport;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Base64;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureMockMvc
@Import(value = { SecurityConf.class })
public class IntegrationTests {

  @Autowired
  MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  @Order(1)
  public void shouldReturnTwoCustomers() throws Exception {

    String name = "Mario";
    String surname = "Rossi";

    mockMvc.perform(MockMvcRequestBuilders.get("/customers/v1"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(jsonPath("$").isArray())
        .andExpect(jsonPath("$.length()").value(2))
        .andExpect(jsonPath("$[1].name").value(name))
        .andExpect(jsonPath("$[1].surname").value(surname));

  }

  @Test
  @Order(2)
  void shouldInsertACustomer() throws Exception {

    CustomerDTO customerDTO = TestSupport.getCustomer(null).toDto();

    String auth = Base64.getEncoder().encodeToString(("admin:admin").getBytes());

    mockMvc.perform(MockMvcRequestBuilders.post("/customers/v1")
            .header(HttpHeaders.AUTHORIZATION, "Basic " + auth)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(customerDTO)))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(jsonPath("$.name").value(customerDTO.getName()))
        .andExpect(jsonPath("$.surname").value(customerDTO.getSurname()));
  }
}
