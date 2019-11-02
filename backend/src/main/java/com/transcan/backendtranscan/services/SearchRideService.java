package com.transcan.backendtranscan.services;

import com.transcan.backendtranscan.domain.RideSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public interface SearchRideService extends JpaRepository<RideSearch,Long> {
   //Optional<ArrayList<RideSearch>> findByUser_info_id(long user_info_Id);
   @Query(value = "SELECT * FROM ride_search u WHERE u.UserInfo.id = :user  ",
           nativeQuery = true)
   ArrayList<RideSearch> findUserID(@Param("user") Long user);

}
