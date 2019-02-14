package com.dojojobportal.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.dojojobportal.models.Job;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=1, max=255, message="This field cannot be blank.")
	private String username;
	
	@Email(message="Invalid Email")
	@Size(min=1, max=255, message="This field cannot be blank.")
	private String email;
	
	@Size(min=8, max=255, message="Password must be atleast 8 characters.")
	private String password;
	
	@Size(min=8, max=255, message="Password must match.")
	@Transient
	private String confirmation;
	
	@Size(min=3, max=255, message="Secret question must atleast be 3 characters long.")
	private String secret_question;
	
	@Size(min=3, max=255, message="Secret answer must atleast be 3 characters long.")
	private String secret_answer;
	
	@Column (updatable = false)
	private Date createdAt;
	private Date updatedAt;

//	<<---------------One To Many Relationship--------------->>
	
	@OneToMany (mappedBy="user", fetch = FetchType.LAZY)
	private List<Job> jobs;
	
//	<<---------------Many To Many Relationship--------------->>
	
//	@ManyToMany(fetch = FetchType.LAZY)
//	@JoinTable(
//			name="users_applying_jobs",
//			joinColumns = @JoinColumn(name = "user_id"),
//			inverseJoinColumns = @JoinColumn(name = "job_id")
//	)
//	private List<Job> appliedjobs;

//	<<---------------Defining Constructor--------------->>
	
	public User() {

	}

	public User(Long id, String username, String email, String password, String confirmation, String secret_question,
		String secret_answer, Date createdAt, Date updatedAt, List<Job> jobs) {
	
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.confirmation = confirmation;
		this.secret_question = secret_question;
		this.secret_answer = secret_answer;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.jobs = jobs;
	}
	
//	<<---------------Getters and Setters--------------->>

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmation() {
		return confirmation;
	}

	public void setConfirmation(String confirmation) {
		this.confirmation = confirmation;
	}

	public String getSecret_question() {
		return secret_question;
	}

	public void setSecret_question(String secret_question) {
		this.secret_question = secret_question;
	}

	public String getSecret_answer() {
		return secret_answer;
	}

	public void setSecret_answer(String secret_answer) {
		this.secret_answer = secret_answer;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

//	public List<Job> getAppliedjobs() {
//		return appliedjobs;
//	}
//
//	public void setJob(List<Job> appliedjobs) {
//		this.appliedjobs = appliedjobs;
//	}
	
//	<<---------------Creating/Updating--------------->>

	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate(){
		this.updatedAt = new Date();
	}

}
