package it.euris.centrosportivobm.controller;

import io.swagger.v3.oas.annotations.Operation;
import it.euris.centrosportivobm.data.dto.CustomerDTO;
import it.euris.centrosportivobm.data.model.Customer;
import it.euris.centrosportivobm.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerController {

  CustomerService customerService;

  @GetMapping("/v1")
  @Operation(description = "This method is used to retrieve all the customers")
  public List<CustomerDTO> getAllCustomers(){
    return customerService.findAll()
        .stream()
        .map(Customer::toDto)
        .toList();
  }

  @PostMapping("/v1")
  public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){
    Customer customer = customerDTO.toModel();
    return customerService.insert(customer).toDto();
  }

  @PutMapping("/v1")
  public CustomerDTO updateCustomer(@RequestBody CustomerDTO customerDTO) {
    Customer customer = customerDTO.toModel();
    return customerService.insert(customer).toDto();
  }

  @DeleteMapping("/v1/{id}")
  public void deleteCustomer(@PathVariable("id") Long idCustomer) {
    customerService.deleteById(idCustomer);
  }

  @GetMapping("/v1/{id}")
  public CustomerDTO getCustomerById(@PathVariable("id") Long idCustomer) {
    return customerService.findById(idCustomer).toDto();
  }
}
