package it.euris.centrosportivobm.controller;

import io.swagger.v3.oas.annotations.Operation;
import it.euris.centrosportivobm.dto.AddressDTO;
import it.euris.centrosportivobm.model.Address;
import it.euris.centrosportivobm.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/address")
public class AddressController {

  AddressService addressService;

  @GetMapping("/v1")
  @Operation(description = "This method is used to retrieve all the addresses")
  public List<AddressDTO> getAllCustomers(){
    return addressService.findAll()
        .stream()
        .map(Address::toDto)
        .toList();
  }

  @PostMapping("/v1")
  public AddressDTO saveCustomer(@RequestBody AddressDTO addressDTO){
    Address address = addressDTO.toModel();
    return addressService.save(address).toDto();
  }

  @PutMapping("/v1")
  public AddressDTO updateCustomer(@RequestBody AddressDTO addressDTO) {
    Address address = addressDTO.toModel();
    return addressService.save(address).toDto();
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
