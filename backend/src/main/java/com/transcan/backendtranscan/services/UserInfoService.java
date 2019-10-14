package com.transcan.backendtranscan.services;

import com.transcan.backendtranscan.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserInfoService extends JpaRepository<UserInfo,Long> {
    Optional<UserInfo> findByEmail(String email);

    @Query(value = "SELECT * FROM  transcan.users u where u.ID=?1",nativeQuery = true)
    Optional<UserInfo> findId(Long Id);

    Optional<UserInfo> findByUsernameOrEmail(String username, String email);

    List<UserInfo> findByIdIn(List<Long> userIds);

    Optional<UserInfo> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}

