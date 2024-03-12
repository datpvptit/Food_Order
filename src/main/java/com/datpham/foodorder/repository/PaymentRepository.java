package com.datpham.foodorder.repository;

import com.datpham.foodorder.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
