package it.euris.centrosportivobm.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import it.euris.centrosportivobm.data.dto.CustomerCourseDTO;
import it.euris.centrosportivobm.data.model.CustomerCourse;
import it.euris.centrosportivobm.data.model.key.CourseCustomerKey;
import it.euris.centrosportivobm.service.CustomerCourseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@SecurityRequirement(name = "authentication")
@RequestMapping("/customers_courses")
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
    return customerCourseService.insert(customerCourse).toDto();
  }

  @PutMapping("/v1")
  public CustomerCourseDTO updateCustomer(@RequestBody CustomerCourseDTO customerCourseDTO) {
    CustomerCourse customerCourse = customerCourseDTO.toModel();
    return customerCourseService.update(customerCourse).toDto();
  }

  @DeleteMapping("/v1/{idCourse}-{idCustomer}")
  public void deleteCustomer(@PathVariable("idCourse") Long courseId, @PathVariable("idCustomer") Long customerId) {
    customerCourseService.deleteById(new CourseCustomerKey(courseId,customerId));
  }

  @GetMapping("/v1/{idCourse}-{idCustomer}")
  public CustomerCourseDTO getCustomerById(@PathVariable("idCourse") Long courseId, @PathVariable("idCustomer") Long customerId) {
    return customerCourseService.findById(new CourseCustomerKey(courseId,customerId)).toDto();
  }

}
