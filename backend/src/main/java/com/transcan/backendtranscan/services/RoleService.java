package com.transcan.backendtranscan.services;

import com.transcan.backendtranscan.domain.Role;
import com.transcan.backendtranscan.domain.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RoleService extends JpaRepository<Role,Long> {
    Optional<Role> findByName(RoleName roleName);
}
