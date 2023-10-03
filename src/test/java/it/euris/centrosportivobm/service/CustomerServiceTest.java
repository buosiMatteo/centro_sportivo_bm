package it.euris.centrosportivobm.service;

import it.euris.centrosportivobm.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CustomerServiceTest {

  @MockBean
  CustomerRepository customerRepository;

  @Autowired
  CustomerService customerService;

}