package com.datpham.foodorder.controller;

import com.datpham.foodorder.entities.Role;
import com.datpham.foodorder.entities.Users;
import com.datpham.foodorder.payload.LoginData;
import com.datpham.foodorder.payload.ResponseData;
import com.datpham.foodorder.payload.SignupData;
import com.datpham.foodorder.repository.UserRepository;
import com.datpham.foodorder.security.JwtUtilities;
import com.datpham.foodorder.service.LoginService;
import com.datpham.foodorder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    JwtUtilities jwtUtilities;
    @Autowired
    LoginService loginService;
    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserRepository userRepository;
    @PostMapping("/login")
    public ResponseEntity<?> signin(@RequestBody LoginData data){
        ResponseData responseData = new ResponseData();
        if(loginService.checkLogin(data.getEmail(), data.getPassword())) {
            Users users = userService.getByEmail(data.getEmail());
            if(!users.isIscheck()){
                responseData.setDesc("Tài khoản chưa được xác thực !");
            }else{
                List<String> roles = new ArrayList<>();
                for(Role role : users.getRoles()){
                    roles.add(role.getRoleName());
                }
                String  token = jwtUtilities.generateToken(data.getEmail(), roles);

                responseData.setSuccess(true);
                responseData.setId(users.getId());
                responseData.setDesc(roles.toString());
                responseData.setData(token);
            }
        }
        else {
            responseData.setSuccess(false);
        }
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupData data){
        ResponseData responseData = new ResponseData();
        if(userRepository.existsByEmail(data.getUsername())){
            responseData.setSuccess(false);
            responseData.setDesc("Email đã tồn tại!");
        } else {
            boolean isSuccess = loginService.addUser(data);
            responseData.setSuccess(isSuccess);
        }

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

}
