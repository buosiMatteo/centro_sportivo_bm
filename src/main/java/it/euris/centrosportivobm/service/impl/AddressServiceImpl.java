package it.euris.centrosportivobm.service.impl;

import it.euris.centrosportivobm.model.Address;
import it.euris.centrosportivobm.repository.AddressRepository;
import it.euris.centrosportivobm.repository.CustomerRepository;
import it.euris.centrosportivobm.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AddressServiceImpl implements AddressService {

  AddressRepository addressRepository;

  @Override
  public List<Address> findAll() {
    return addressRepository.findAll();
  }

  @Override
  public Address save(Address address) {
    return addressRepository.save(address);
  }

  @Override
  public void deleteById(Long idAddress) {
    addressRepository.deleteById(idAddress);
  }

  @Override
  public Address findById(Long idAddress) {
    return addressRepository.findById(idAddress).orElse(Address.builder().build());
  }
}
