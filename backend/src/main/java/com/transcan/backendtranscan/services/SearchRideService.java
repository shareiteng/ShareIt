package com.transcan.backendtranscan.services;

import com.transcan.backendtranscan.domain.RideSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchRideService extends JpaRepository<RideSearch,Integer> {
}
