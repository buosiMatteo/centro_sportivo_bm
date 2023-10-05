package it.euris.centrosportivobm.service.impl;

import it.euris.centrosportivobm.data.model.Address;
import it.euris.centrosportivobm.exception.IdMustBeNullException;
import it.euris.centrosportivobm.exception.IdMustNotBeNullException;
import it.euris.centrosportivobm.repository.AddressRepository;
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
  public Address insert(Address address) {
    if (address.getId() != null) {
      throw new IdMustBeNullException();
    }
    return addressRepository.save(address);
  }

  @Override
  public Address update(Address address) {
    if (address.getId() == null) {
      throw new IdMustNotBeNullException();
    }
    return addressRepository.save(address);
  }

  @Override
  public Boolean deleteById(Long idAddress) {
    addressRepository.deleteById(idAddress);
    return addressRepository.findById(idAddress).isEmpty();
  }

  @Override
  public Address findById(Long idAddress) {
    return addressRepository.findById(idAddress).orElse(Address.builder().build());
  }
}
