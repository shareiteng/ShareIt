package com.transcan.backendtranscan.services;

import com.transcan.backendtranscan.domain.RideSearch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SearchRideService extends JpaRepository<RideSearch,Long> {
}
