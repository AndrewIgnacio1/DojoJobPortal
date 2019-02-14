package com.dojojobportal.models;

import java.util.Date;
//import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.dojojobportal.models.User;

@Entity
@Table(name="jobs")
public class Job {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=1, max=255, message="This field cannot be blank.")
	private String jobName;
	
	@Size(min=1, max=255, message="This field cannot be blank.")
	private String jobCompany;
	
	@Size(min=1, max=255, message="This field cannot be blank.")
	private String jobPosition;
	
	@Size(min=1, max=255, message="This field cannot be blank.")
	private String jobDescription;
	
	@Size(min=1, max=255, message="This field cannot be blank.")
	private String jobLink;
	
	@Column (updatable = false)
	private Date createdAt;
	private Date updatedAt;

//<<---------------One To Many Relationship--------------->>

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;

//<<---------------Many To Many Relationship--------------->>
	
//	@ManyToMany(fetch = FetchType.LAZY)
//	@JoinTable(
//		name="users_applying_jobs",
//		joinColumns = @JoinColumn(name = "job_id"),
//		inverseJoinColumns = @JoinColumn(name = "user_id")
//	)
//	private List<User> users;
	
//	<<---------------Defining Constructor--------------->>
	
	public Job() {

	}

	public Job(Long id, String jobName, String jobCompany, String jobPosition, String jobDescription, String jobLink,
		Date createdAt, Date updatedAt, User user) {
	
		this.id = id;
		this.jobName = jobName;
		this.jobCompany = jobCompany;
		this.jobPosition = jobPosition;
		this.jobDescription = jobDescription;
		this.jobLink = jobLink;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.user = user;
//		this.users = users;
	}

//	<<---------------Getters and Setters--------------->>
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobCompany() {
		return jobCompany;
	}

	public void setJobCompany(String jobCompany) {
		this.jobCompany = jobCompany;
	}

	public String getJobPosition() {
		return jobPosition;
	}

	public void setJobPosition(String jobPosition) {
		this.jobPosition = jobPosition;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getJobLink() {
		return jobLink;
	}

	public void setJobLink(String jobLink) {
		this.jobLink = jobLink;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

//	public List<User> getUsers() {
//		return users;
//	}
//
//	public void setUsers(List<User> users) {
//		this.users = users;
//	}
	
	//<<---------------Creating/Updating--------------->>

	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate(){
		this.updatedAt = new Date();
	}
	
}
