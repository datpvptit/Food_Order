package com.datpham.foodorder.repository;

import com.datpham.foodorder.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users,Integer> {
    Users findById(int id);

    Boolean existsByEmail(String email);
    Boolean existsByEmailAndPassword(String email, String password);
    Optional<Users> findByEmail(String email);
}


