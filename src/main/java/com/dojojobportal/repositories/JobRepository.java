package com.dojojobportal.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.dojojobportal.models.Job;

public interface JobRepository extends CrudRepository<Job, Long> {

	public List<Job> findAll();
	
	Optional<Job> findByName( String name );
	
	Optional<Job> findById( Long id );
	
}