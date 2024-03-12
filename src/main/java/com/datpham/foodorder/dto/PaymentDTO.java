package com.datpham.foodorder.dto;

import lombok.Data;

@Data
public class PaymentDTO {
    private int orderID;
    private String method;
}
