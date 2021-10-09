package com.lexical.SpringTutorial;

import com.lexical.SpringTutorial.io.entity.AddressEntity;
import com.lexical.SpringTutorial.io.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressRepository extends CrudRepository<AddressEntity, Long> {

    List<AddressEntity> findALlByUserDetails(UserEntity userEntity);
    AddressEntity findByAddressId(String addressId);
}
