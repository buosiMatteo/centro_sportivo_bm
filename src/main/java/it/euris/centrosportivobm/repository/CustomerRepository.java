package it.euris.centrosportivobm.repository;

import it.euris.centrosportivobm.data.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
