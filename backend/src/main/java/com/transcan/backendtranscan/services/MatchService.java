package com.transcan.backendtranscan.services;

import com.transcan.backendtranscan.domain.BestMatch;
import com.transcan.backendtranscan.domain.RideSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;


public interface MatchService extends JpaRepository<BestMatch,Long> {
    @Query(value = "SELECT * FROM bestmatch u WHERE u.user_info_id = :user",
            nativeQuery = true)
    ArrayList<BestMatch> findUserID(@Param("user") Long user);
}
