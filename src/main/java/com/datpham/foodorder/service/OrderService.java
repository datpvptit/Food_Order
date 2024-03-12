package com.datpham.foodorder.service;

import com.datpham.foodorder.dto.OrderDTO;
import com.datpham.foodorder.payload.ResponseData;

public interface OrderService {
    ResponseData addOrder (OrderDTO orderDTO);
}
