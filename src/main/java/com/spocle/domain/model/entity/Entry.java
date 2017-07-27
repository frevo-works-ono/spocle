package com.spocle.domain.model.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Entity
@Table(name = "entries")
@Data
@EntityListeners(value = AuditingEntityListener.class)
public class Entry {

	@Id
	private String id;

	@Column
	private String comment;

	@ManyToOne
	private Event event;

	@ManyToOne
	private Member member;

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

}
