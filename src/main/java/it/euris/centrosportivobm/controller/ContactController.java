package it.euris.centrosportivobm.controller;

import io.swagger.v3.oas.annotations.Operation;
import it.euris.centrosportivobm.data.dto.ContactDTO;
import it.euris.centrosportivobm.data.model.Contact;
import it.euris.centrosportivobm.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/contacts")
public class ContactController {

  ContactService contactService;

  @GetMapping("/v1")
  @Operation(description = "This method is used to retrieve all the contacts")
  public List<ContactDTO> getAllCustomers(){
    return contactService.findAll()
        .stream()
        .map(Contact::toDto)
        .toList();
  }

  @PostMapping("/v1")
  public ContactDTO saveCustomer(@RequestBody ContactDTO contactDTO){
    Contact contact = contactDTO.toModel();
    return contactService.save(contact).toDto();
  }

  @PutMapping("/v1")
  public ContactDTO updateCustomer(@RequestBody ContactDTO contactDTO) {
    Contact contact = contactDTO.toModel();
    return contactService.save(contact).toDto();
  }

  @DeleteMapping("/v1/{id}")
  public void deleteCustomer(@PathVariable("id") Long idContact) {
    contactService.deleteById(idContact);
  }

  @GetMapping("/v1/{id}")
  public ContactDTO getCustomerById(@PathVariable("id") Long idContact) {
    return contactService.findById(idContact).toDto();
  }
}
