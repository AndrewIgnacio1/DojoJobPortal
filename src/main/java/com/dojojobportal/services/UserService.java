package com.dojojobportal.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.dojojobportal.models.Job;
import com.dojojobportal.models.User;
import com.dojojobportal.repositories.JobRepository;
import com.dojojobportal.repositories.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	private final JobRepository jobRepository;

	public UserService (UserRepository userRepository, JobRepository jobRepository) {
		
		this.userRepository = userRepository;
		this.jobRepository = jobRepository;
	}
	
//	<<---------------Create--------------->>
	
	public User createUser(User user) {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return userRepository.save(user);
	}
	
	public Job createJob(Job job) {
		return jobRepository.save(job);
	}
	
//	<<---------------Read--------------->>
	
	public Boolean checkIt( User user, String password ) {
		return BCrypt.checkpw(password, user.getPassword());
	}
	
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}
	
	public User findById(Long id) {
		return userRepository.findById(id).get();
	}
	
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public List<Job> findAllJobs() {
		return jobRepository.findAll();
	}
	
	public Job findJobById(Long id) {
		return jobRepository.findById(id).get();
	}
	
	public Job findJobByName(String name) {
		
		Optional<Job> job = jobRepository.findByName( name );
		
		if ( job.isPresent() ) {
			return job.get();
		} 
		
		else {
			return null;
		}
	}
	
//	<<---------------Update--------------->>
	
	public User updateUser(User user) {
		return userRepository.save(user);
	}
	
	public Job updateJob(Job job) {
		return jobRepository.save(job);
	}
	
//	<<---------------Destroy--------------->>
	
	public void deleteUser(User user) {
		userRepository.delete(user);
	}
	
	public void deleteJob(Job job) {
		jobRepository.delete(job);
	}
	
//	<<---------------User Authentication--------------->>	
	
	public boolean authenticateUser(String email, String password) {
		User user = userRepository.findByEmail(email);
		
		if (user == null) {
			return false;
		}
		
		else {
			
			if (BCrypt.checkpw(password, user.getPassword())) {
				return true;
			}
			
			else {
				return false;
			}
		}
	}
	
}
