package it.euris.centrosportivobm.service;

import it.euris.centrosportivobm.data.model.Address;

import java.util.List;

public interface AddressService {
  List<Address> findAll();

  Address save(Address address);

  void deleteById(Long idAddress);

  Address findById(Long idAddress);
}
