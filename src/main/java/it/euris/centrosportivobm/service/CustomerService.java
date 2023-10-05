package it.euris.centrosportivobm.service;

import it.euris.centrosportivobm.data.model.Customer;

import java.util.List;


public interface CustomerService {
  List<Customer> findAll();

  Customer insert(Customer customer);

  Customer update(Customer customer);

  Boolean deleteById(Long idCustomer);

  Customer findById(Long idCustomer);
}
