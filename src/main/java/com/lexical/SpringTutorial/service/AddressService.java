package com.lexical.SpringTutorial.service;

import com.lexical.SpringTutorial.shared.dto.AddressDTO;

import java.util.List;

public interface AddressService {
    List<AddressDTO> getAddresses(String userId);
    AddressDTO getAddress(String addressId);
}
