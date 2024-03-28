package com.example.securitybasic.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.securitybasic.model.dto.UserDto;


public interface UserRepository extends JpaRepository<UserDto, String> {
    
    @Query(value = "select * from custom where name = :name", nativeQuery = true)
    public UserDto getUserDtoByName(@Param(value = "name") String name);

}
