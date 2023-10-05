package it.euris.centrosportivobm.controller;

import it.euris.centrosportivobm.data.model.Address;
import it.euris.centrosportivobm.service.AddressService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AddressController.class)
class AddressControllerTest {

  @Autowired
  MockMvc mockMvc;

  @MockBean
  AddressService addressService;

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

    when(addressService.save(address)).thenReturn(address);

    mockMvc.perform(MockMvcRequestBuilders.get("/address/v1"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON));
  }

}