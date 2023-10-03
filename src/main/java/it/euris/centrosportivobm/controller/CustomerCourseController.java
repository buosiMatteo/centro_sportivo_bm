package it.euris.centrosportivobm.controller;

import io.swagger.v3.oas.annotations.Operation;
import it.euris.centrosportivobm.data.dto.CustomerCourseDTO;
import it.euris.centrosportivobm.data.dto.CustomerDTO;
import it.euris.centrosportivobm.data.model.Customer;
import it.euris.centrosportivobm.data.model.CustomerCourse;
import it.euris.centrosportivobm.data.model.key.CustomerCourseKey;
import it.euris.centrosportivobm.service.CustomerCourseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/customers_course")
public class CustomerCourseController {

  CustomerCourseService customerCourseService;

  @GetMapping("/v1")
  @Operation(description = "This method is used to retrieve all the customers_course")
  public List<CustomerCourseDTO> getAllCustomers(){
    return customerCourseService.findAll()
        .stream()
        .map(CustomerCourse::toDto)
        .toList();
  }

  @PostMapping("/v1")
  public CustomerCourseDTO saveCustomer(@RequestBody CustomerCourseDTO customerCourseDTO){
    CustomerCourse customerCourse = customerCourseDTO.toModel();
    return customerCourseService.save(customerCourse).toDto();
  }

  @PutMapping("/v1")
  public CustomerCourseDTO updateCustomer(@RequestBody CustomerCourseDTO customerCourseDTO) {
    CustomerCourse customerCourse = customerCourseDTO.toModel();
    return customerCourseService.save(customerCourse).toDto();
  }

  @DeleteMapping("/v1/{id}")
  public void deleteCustomer(@PathVariable("id") CustomerCourseKey idCustomerCourse) {
    customerCourseService.deleteById(idCustomerCourse);
  }

  @GetMapping("/v1/{id}")
  public CustomerCourseDTO getCustomerById(@PathVariable("id") CustomerCourseKey idCustomerCourse) {
    return customerCourseService.findById(idCustomerCourse).toDto();
  }

}