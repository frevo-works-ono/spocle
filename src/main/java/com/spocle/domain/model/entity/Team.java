package com.spocle.domain.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "teams")
@Data
@EntityListeners(value = AuditingEntityListener.class)
public class Team implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;

	@Column
	private String name;

	@Column(name = "establish_date")
	private Date establishDate;

	@Column
	private String category;

	@Column
	private String level;

	@Column(name = "activity_place")
	private String activityPlace;

	@Column(name = "activity_date")
	private String activityDate;

	@Column(name = "line_group_id")
	private String lineGroupId;

	@Column(name = "line_status")
	private int lineStatus;

	@OneToMany
	@JsonIgnore
	private List<Member> members;

	@OneToMany
	@JsonIgnore
	private List<Event> events;

	@Basic
	@CreatedBy
	@Column(name = "create_user")
	private String createUser;

	@Basic
	@CreatedDate
	@Column(name = "create_date")
	private Date createDate;

	@Basic
	@LastModifiedBy
	@Column(name = "update_user")
	private String updateUser;

	@Basic
	@LastModifiedDate
	@Column(name = "update_date")
	private Date updateDate;
	
	public Team(){
		this.id = UUID.randomUUID().toString();
	}
	
	public Team(String id){
		this.id = id;
	}
}
