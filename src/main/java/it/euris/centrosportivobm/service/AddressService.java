package it.euris.centrosportivobm.service;

import it.euris.centrosportivobm.data.model.Address;

import java.util.List;

public interface AddressService {
  List<Address> findAll();

  Address insert(Address address);

  Address update(Address address);

  Boolean deleteById(Long idAddress);

  Address findById(Long idAddress);
}
