package com.datpham.foodorder.service;

import com.datpham.foodorder.payload.SignupData;
import org.springframework.stereotype.Service;

import java.util.List;


public interface LoginService {
    boolean checkLogin(String username, String password);
    boolean addUser(SignupData data);
}
