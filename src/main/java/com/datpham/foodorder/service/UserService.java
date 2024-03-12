package com.datpham.foodorder.service;


import com.datpham.foodorder.dto.LoginDTO;
import com.datpham.foodorder.dto.RegisterDTO;
import com.datpham.foodorder.entities.Role;
import com.datpham.foodorder.entities.Users;
import org.springframework.http.ResponseEntity;


public interface UserService {
   //ResponseEntity<?> register (RegisterDto registerDto);
 //  ResponseEntity<BearerToken> authenticate(LoginDto loginDto);

   String authenticate(LoginDTO loginDto);
   ResponseEntity<?> register (RegisterDTO registerDto);
   Role saveRole(Role role);

   Users saverUser (Users users) ;
   Users getByEmail(String email);
}
