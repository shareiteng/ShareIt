package com.transcan.backendtranscan.services;

import com.transcan.backendtranscan.domain.RideSearch;
import org.springframework.data.repository.CrudRepository;

public interface SearchRideService extends CrudRepository<RideSearch,Integer> {
}
