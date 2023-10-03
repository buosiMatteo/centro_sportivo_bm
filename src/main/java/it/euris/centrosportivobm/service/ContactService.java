package it.euris.centrosportivobm.service;

import it.euris.centrosportivobm.data.model.Contact;

import java.util.List;

public interface ContactService {
  List<Contact> findAll();

  Contact save(Contact contact);

  void deleteById(Long idContact);

  Contact findById(Long idContact);
}
