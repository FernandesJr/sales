package com.siganatural.sales.repositories;

import com.siganatural.sales.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
