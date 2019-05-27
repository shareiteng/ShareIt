package com.transcan.backendtranscan.services;

import com.transcan.backendtranscan.domain.UserInfo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserInfoService extends CrudRepository<UserInfo,Integer> {
    List<UserInfo> findByUsername(String username);
}

