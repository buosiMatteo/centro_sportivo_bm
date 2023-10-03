package it.euris.centrosportivobm.service.impl;

import it.euris.centrosportivobm.data.model.Contact;
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
  public Contact save(Contact contact) {
    return contactRepository.save(contact);
  }

  @Override
  public void deleteById(Long idContact) {
    contactRepository.deleteById(idContact);
  }

  @Override
  public Contact findById(Long idContact) {
    return contactRepository.findById(idContact).orElse(Contact.builder().build());
  }
}
