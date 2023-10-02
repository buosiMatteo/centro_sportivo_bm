package it.euris.centrosportivobm.service;

import it.euris.centrosportivobm.model.Customer;

import java.util.List;


public interface CustomerService {
  List<Customer> findAll();

  Customer save(Customer customer);

  void deleteById(Long idCustomer);

  Customer findById(Long idCustomer);
}
