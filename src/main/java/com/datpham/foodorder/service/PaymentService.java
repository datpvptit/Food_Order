package com.datpham.foodorder.service;

import com.datpham.foodorder.dto.PaymentDTO;
import com.datpham.foodorder.entities.Payment;

public interface PaymentService {
    boolean addPayment(PaymentDTO paymentDTO);
}
