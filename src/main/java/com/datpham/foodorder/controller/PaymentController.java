package com.datpham.foodorder.controller;

import com.datpham.foodorder.dto.PaymentDTO;
import com.datpham.foodorder.payload.ResponseData;
import com.datpham.foodorder.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @PreAuthorize("hasAuthority('USER')")
    @PostMapping("/add")
    public ResponseEntity<?> addOrder(@RequestBody PaymentDTO paymentDTO){
        ResponseData responseData = new ResponseData();
        responseData.setSuccess(paymentService.addPayment(paymentDTO));
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
