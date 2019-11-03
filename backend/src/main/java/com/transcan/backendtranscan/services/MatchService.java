package com.transcan.backendtranscan.services;

import com.transcan.backendtranscan.domain.BestMatch;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MatchService extends JpaRepository<BestMatch,Long> {
}
