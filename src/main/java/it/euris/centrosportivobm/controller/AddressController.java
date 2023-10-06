package it.euris.centrosportivobm.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import it.euris.centrosportivobm.data.dto.AddressDTO;
import it.euris.centrosportivobm.data.model.Address;
import it.euris.centrosportivobm.exception.IdMustBeNullException;
import it.euris.centrosportivobm.exception.IdMustNotBeNullException;
import it.euris.centrosportivobm.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor
@RestController
@SecurityRequirement(name = "authentication")
@RequestMapping("/address")
public class AddressController {

  AddressService addressService;

  @GetMapping("/v1")
  @Operation(description = "This method is used to retrieve all the addresses")
  public List<AddressDTO> getAllCustomers() {
    return addressService.findAll()
        .stream()
        .map(Address::toDto)
        .toList();
  }

  @PostMapping("/v1")
  public AddressDTO saveCustomer(@RequestBody AddressDTO addressDTO) {
    try {
      Address address = addressDTO.toModel();
      return addressService.insert(address).toDto();
    } catch (IdMustBeNullException e) {
      throw new ResponseStatusException(
          HttpStatus.BAD_REQUEST, e.getMessage());
    }
  }

  @PutMapping("/v1")
  public AddressDTO updateCustomer(@RequestBody AddressDTO addressDTO) {
    try {
      Address address = addressDTO.toModel();
      return addressService.update(address).toDto();
    } catch (IdMustNotBeNullException e) {
      throw new ResponseStatusException(
          HttpStatus.BAD_REQUEST, e.getMessage());
    }
  }

  @DeleteMapping("/v1/{id}")
  public void deleteCustomer(@PathVariable("id") Long idAddress) {
    addressService.deleteById(idAddress);
  }

  @GetMapping("/v1/{id}")
  public AddressDTO getCustomerById(@PathVariable("id") Long idAddress) {
    return addressService.findById(idAddress).toDto();
  }

}
