package com.datpham.foodorder.service.Impl;

import com.datpham.foodorder.entities.Role;
import com.datpham.foodorder.entities.RoleName;
import com.datpham.foodorder.entities.Users;
import com.datpham.foodorder.payload.SignupData;
import com.datpham.foodorder.repository.RoleRepository;
import com.datpham.foodorder.repository.UserRepository;
import com.datpham.foodorder.service.LoginService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public boolean checkLogin(String email, String password) {
        Users user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return passwordEncoder.matches(password, user.getPassword());
    }

    @Override
    public boolean addUser(SignupData data) {
        Users users = new Users();
        users.setEmail(data.getUsername());
        users.setPassword(passwordEncoder.encode(data.getPassword()));
        List<Role> roles = new ArrayList<>();
        for (String name : data.getRoles()){
            roles.add(roleRepository.findByRoleName(RoleName.valueOf(name.toUpperCase())));
        }
        users.setRoles(roles);
        users.setIscheck(false);

        userRepository.save(users);
        try {
            Users savedUser = userRepository.save(users);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
