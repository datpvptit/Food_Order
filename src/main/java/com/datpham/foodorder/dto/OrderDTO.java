package com.datpham.foodorder.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderDTO {
    private int userId;
    private List<OrderItemDTO> orderItemDTOList;
}
