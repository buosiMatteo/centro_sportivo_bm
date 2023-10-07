package it.euris.centrosportivobm.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import it.euris.centrosportivobm.data.dto.CourseDTO;
import it.euris.centrosportivobm.data.model.Course;
import it.euris.centrosportivobm.exception.IdMustBeNullException;
import it.euris.centrosportivobm.exception.IdMustNotBeNullException;
import it.euris.centrosportivobm.repository.projection.CourseCountProjection;
import it.euris.centrosportivobm.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor
@RestController
@SecurityRequirement(name = "authentication")
@RequestMapping("/courses")
public class CourseController {

  CourseService courseService;

  @GetMapping("/v1")
  @Operation(description = "This method is used to retrieve all the courses")
  public List<CourseDTO> getAllCustomers() {
    return courseService.findAll()
        .stream()
        .map(Course::toDto)
        .toList();
  }

  @PostMapping("/v1")
  public CourseDTO saveCustomer(@RequestBody CourseDTO courseDTO) {
    try {
      Course course = courseDTO.toModel();
      return courseService.insert(course).toDto();
    } catch (IdMustBeNullException e) {
      throw new ResponseStatusException(
          HttpStatus.BAD_REQUEST, e.getMessage());
    }
  }

  @PutMapping("/v1")
  public CourseDTO updateCustomer(@RequestBody CourseDTO courseDTO) {
    try {
      Course course = courseDTO.toModel();
      return courseService.update(course).toDto();
    } catch (IdMustNotBeNullException e) {
      throw new ResponseStatusException(
          HttpStatus.BAD_REQUEST, e.getMessage());
    }
  }

  @DeleteMapping("/v1/{id}")
  public void deleteCustomer(@PathVariable("id") Long idCourse) {
    courseService.deleteById(idCourse);
  }

  @GetMapping("/v1/{id}")
  public CourseDTO getCustomerById(@PathVariable("id") Long idCourse) {
    return courseService.findById(idCourse).toDto();
  }

  @GetMapping("/v1/count")
  public CourseCountProjection getCount(){
    return courseService.getCount();
  }
}
