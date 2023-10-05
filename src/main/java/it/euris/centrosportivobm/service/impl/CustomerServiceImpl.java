package it.euris.centrosportivobm.service.impl;

import it.euris.centrosportivobm.data.model.Customer;
import it.euris.centrosportivobm.exception.IdMustBeNullException;
import it.euris.centrosportivobm.exception.IdMustNotBeNullException;
import it.euris.centrosportivobm.repository.CustomerRepository;
import it.euris.centrosportivobm.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

  CustomerRepository customerRepository;
  @Override
  public List<Customer> findAll() {
    return customerRepository.findAll();
  }

  @Override
  public Customer insert(Customer customer) {
    if (customer.getId() != null){
      throw new IdMustBeNullException();
    }
    return customerRepository.save(customer);
  }

  @Override
  public Customer update(Customer customer) {
    if (customer.getId() == null){
      throw new IdMustNotBeNullException();
    }
    return customerRepository.save(customer);
  }

  @Override
  public Boolean deleteById(Long idCustomer) {
    customerRepository.deleteById(idCustomer);
    return customerRepository.findById(idCustomer).isEmpty();
  }

  @Override
  public Customer findById(Long idCustomer) {
    return customerRepository.findById(idCustomer).orElse(Customer.builder().build());
  }
}
