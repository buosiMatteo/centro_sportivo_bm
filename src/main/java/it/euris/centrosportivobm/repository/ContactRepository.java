package it.euris.centrosportivobm.repository;

import it.euris.centrosportivobm.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact,Long> {

}
