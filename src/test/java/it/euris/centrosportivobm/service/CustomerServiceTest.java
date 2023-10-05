package it.euris.centrosportivobm.service;

import it.euris.centrosportivobm.data.model.Customer;
import it.euris.centrosportivobm.exception.IdMustBeNullException;
import it.euris.centrosportivobm.exception.IdMustNotBeNullException;
import it.euris.centrosportivobm.repository.CustomerRepository;
import it.euris.centrosportivobm.service.impl.CustomerServiceImpl;
import it.euris.centrosportivobm.utility.TestSupport;
import org.assertj.core.api.recursive.comparison.ComparingSnakeOrCamelCaseFields;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

  @Mock
  CustomerRepository customerRepository;

  @InjectMocks
  CustomerServiceImpl customerService;

  @Test
  void shouldReturnACustomer(){

    Customer customer = TestSupport.getCustomer(1L);

    List<Customer> customers = List.of(customer);

    when(customerRepository.findAll()).thenReturn(customers);

    List<Customer> returnedCustomers = customerService.findAll();

    assertThat(returnedCustomers)
        .hasSize(1)
        .first()
        .usingRecursiveComparison()
        .withIntrospectionStrategy(new ComparingSnakeOrCamelCaseFields())
        .isEqualTo(customer);
  }

  @Test
  void shouldInsertACustomer(){

    Customer customer = TestSupport.getCustomer(null);

    when(customerRepository.save(any())).thenReturn(customer);

    Customer returnedCustomer = customerService.insert(customer);
    assertThat(returnedCustomer.getName())
        .isEqualTo(customer.getName());
  }

  @Test
  void shouldNotInsertAnyCustomer(){

    Customer customer = TestSupport.getCustomer(1L);
    lenient().when(customerRepository.save(any())).thenReturn(customer);

    assertThrows(IdMustBeNullException.class, () -> customerService.insert(customer));

    assertThatThrownBy(() -> customerService.insert(customer))
        .isInstanceOf(IdMustBeNullException.class);

  }

  @Test
  void shouldUpdateACustomer(){

    Customer customer = TestSupport.getCustomer(1L);

    when(customerRepository.save(any())).thenReturn(customer);

    Customer returnedCustomer = customerService.update(customer);
    assertThat(returnedCustomer.getName())
        .isEqualTo(customer.getName());
  }

  @Test
  void shouldNotUpdateAnyCustomer(){

    Customer customer = TestSupport.getCustomer(null);
    lenient().when(customerRepository.save(any())).thenReturn(customer);

    assertThatThrownBy(() -> customerService.update(customer))
        .isInstanceOf(IdMustNotBeNullException.class);
  }

  @Test
  void shouldDeleteACustomer() {
    //arrange
    Long id = 12L;

    doNothing().when(customerRepository).deleteById(anyLong());
    when(customerRepository.findById(id)).thenReturn(Optional.empty());
    assertTrue(customerService.deleteById(id));
    Mockito.verify(customerRepository, times(1)).deleteById(id);
  }

}