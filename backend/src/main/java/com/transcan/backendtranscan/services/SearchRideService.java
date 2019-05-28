package com.transcan.backendtranscan.services;

import com.transcan.backendtranscan.domain.SearchRide;
import org.springframework.data.repository.CrudRepository;

public interface SearchRideService extends CrudRepository<SearchRide,Integer> {
}
