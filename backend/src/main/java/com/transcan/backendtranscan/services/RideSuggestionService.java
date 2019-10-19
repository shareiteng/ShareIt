package com.transcan.backendtranscan.services;

import com.transcan.backendtranscan.domain.RideSuggestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RideSuggestionService extends JpaRepository<RideSuggestion,Long> {

}
