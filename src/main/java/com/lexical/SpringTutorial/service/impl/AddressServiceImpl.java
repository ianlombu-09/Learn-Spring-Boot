package com.lexical.SpringTutorial.service.impl;

import com.lexical.SpringTutorial.AddressRepository;
import com.lexical.SpringTutorial.UserRepository;
import com.lexical.SpringTutorial.io.entity.AddressEntity;
import com.lexical.SpringTutorial.io.entity.UserEntity;
import com.lexical.SpringTutorial.service.AddressService;
import com.lexical.SpringTutorial.shared.dto.AddressDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AddressRepository addressRepository;

    @Override
    public List<AddressDTO> getAddresses(String userId) {
        List<AddressDTO> returnValue = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();

        UserEntity userEntity = userRepository.findByUserId(userId);
        if (userEntity == null) return  returnValue;

        Iterable<AddressEntity> addresses = addressRepository.findALlByUserDetails(userEntity);

        for (AddressEntity addressEntity: addresses) {
            returnValue.add( modelMapper.map(addressEntity, AddressDTO.class));
        }

        return returnValue;
    }

    public AddressDTO getAddress(String addressId) {
        AddressDTO returnValue = null;

        AddressEntity addressEntity = addressRepository.findByAddressId(addressId);

        if (addressEntity != null) {
            returnValue = new ModelMapper().map(addressEntity, AddressDTO.class);
        }

        return returnValue;
    }
}
