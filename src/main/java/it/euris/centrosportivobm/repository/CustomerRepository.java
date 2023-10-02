package it.euris.centrosportivobm.repository;

import it.euris.centrosportivobm.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
