package it.euris.centrosportivobm.service.impl;

import it.euris.centrosportivobm.data.model.Contact;
import it.euris.centrosportivobm.data.model.Course;
import it.euris.centrosportivobm.exception.IdMustBeNullException;
import it.euris.centrosportivobm.exception.IdMustNotBeNullException;
import it.euris.centrosportivobm.repository.ContactRepository;
import it.euris.centrosportivobm.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ContactServiceImpl implements ContactService {

  ContactRepository contactRepository;


  @Override
  public List<Contact> findAll() {
    return contactRepository.findAll();
  }

  @Override
  public Contact insert(Contact contact) {
    if (contact.getId() != null) {
      throw new IdMustBeNullException();
    }
    return contactRepository.save(contact);
  }

  @Override
  public Contact update(Contact contact) {
    if (contact.getId() == null) {
      throw new IdMustNotBeNullException();
    }
    return contactRepository.save(contact);
  }

  @Override
  public Boolean deleteById(Long idContact) {
    contactRepository.deleteById(idContact);
    return contactRepository.findById(idContact).isEmpty();
  }

  @Override
  public Contact findById(Long idContact) {
    return contactRepository.findById(idContact).orElse(Contact.builder().build());
  }
}
