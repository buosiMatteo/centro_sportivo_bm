package it.euris.centrosportivobm.controller;

import io.swagger.v3.oas.annotations.Operation;
import it.euris.centrosportivobm.dto.CourseDTO;
import it.euris.centrosportivobm.model.Course;
import it.euris.centrosportivobm.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/courses")
public class CourseController {

  CourseService courseService;

  @GetMapping("/v1")
  @Operation(description = "This method is used to retrieve all the courses")
  public List<CourseDTO> getAllCustomers(){
    return courseService.findAll()
        .stream()
        .map(Course::toDto)
        .toList();
  }

  @PostMapping("/v1")
  public CourseDTO saveCustomer(@RequestBody CourseDTO courseDTO){
    Course course = courseDTO.toModel();
    return courseService.save(course).toDto();
  }

  @PutMapping("/v1")
  public CourseDTO updateCustomer(@RequestBody CourseDTO courseDTO) {
    Course course = courseDTO.toModel();
    return courseService.save(course).toDto();
  }

  @DeleteMapping("/v1/{id}")
  public void deleteCustomer(@PathVariable("id") Long idCourse) {
    courseService.deleteById(idCourse);
  }

  @GetMapping("/v1/{id}")
  public CourseDTO getCustomerById(@PathVariable("id") Long idCourse) {
    return courseService.findById(idCourse).toDto();
  }
}
