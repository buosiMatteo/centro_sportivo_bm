package it.euris.centrosportivobm.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.euris.centrosportivobm.config.security.SecurityConf;
import it.euris.centrosportivobm.data.model.Address;
import it.euris.centrosportivobm.service.AddressService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Base64;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Import(value = { SecurityConf.class })
class AddressControllerTest {

  @Autowired
  MockMvc mockMvc;

  @MockBean
  AddressService addressService;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  public void shouldGetOneAddress() throws Exception {

    Address address = Address
        .builder()
        .address("Via Roma 17")
        .city("Milano")
        .deleted(false)
        .nation("Italy")
        .postalCode(20061)
        .province("MI")
        .build();

    List<Address> addresses = List.of(address);

    when(addressService.findAll()).thenReturn(addresses);

    mockMvc.perform(MockMvcRequestBuilders.get("/address/v1"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$").isArray())
        .andExpect(jsonPath("$.length()").value(1));

  }

  @Test
  public void shouldSaveAnAddress() throws Exception {
    Address address = Address
        .builder()
        .address("Via Roma 17")
        .city("Milano")
        .deleted(false)
        .nation("Italy")
        .postalCode(20061)
        .province("MI")
        .build();

    when(addressService.insert(address)).thenReturn(address);

    String auth = Base64.getEncoder().encodeToString(("admin:admin").getBytes());

    mockMvc.perform(MockMvcRequestBuilders.post("/address/v1")
            .header(HttpHeaders.AUTHORIZATION, "Basic " + auth)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(address.toDto())))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
  }

  @Test
  void shouldReturnForbiddenWhenUserAuthenticated() throws Exception {

    Address address = Address
        .builder()
        .address("Via Roma 17")
        .city("Milano")
        .deleted(false)
        .nation("Italy")
        .postalCode(20061)
        .province("MI")
        .build();;

    when(addressService.insert(any())).thenReturn(address);

    String auth = Base64.getEncoder().encodeToString(("user:user").getBytes());

    mockMvc.perform(MockMvcRequestBuilders.post("/customers/v1")
            .header(HttpHeaders.AUTHORIZATION, "Basic " + auth)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(address.toDto())))
        .andDo(print())
        .andExpect(status().isForbidden());
  }

}