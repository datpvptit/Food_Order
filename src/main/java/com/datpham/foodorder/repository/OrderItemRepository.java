package com.datpham.foodorder.repository;

import com.datpham.foodorder.Keys.IdOrderDetail;
import com.datpham.foodorder.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, IdOrderDetail> {
}
