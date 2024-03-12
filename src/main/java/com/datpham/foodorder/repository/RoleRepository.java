package com.datpham.foodorder.repository;

import com.datpham.foodorder.entities.Role;
import com.datpham.foodorder.entities.RoleName;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    Role findByRoleName(RoleName roleName);
}
