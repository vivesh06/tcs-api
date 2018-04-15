package com.tcs.api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tcs.api.model.TermsAndConditions;

public interface TcsRepository extends MongoRepository<TermsAndConditions, Long>{

	List<TermsAndConditions> findByNameAndStatusAndVersionAndChannels(String name, String status, String version, List<String> channels);
	
}
