package com.spocle.domain.model.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

import com.spocle.util.DateUtil;

import lombok.Data;

@Entity
@Table(name = "events")
@Data
@EntityListeners(value = AuditingEntityListener.class)
public class Event {

	@Id
	private String id;

	@Column
	private String name;

	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "end_date")
	private Date endDate;

	@Column
	private String detail;

	@Column(name = "due_date")
	private Date dueDate;

	@ManyToOne
	private Team team;

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

	public Event() {
		this.id = UUID.randomUUID().toString();
	}

	public void setStartDate(String date) {
		this.startDate = DateUtil.parse(date, "yyyy/MM/dd HH:mm");
	}

	public void setEndDate(String date) {
		this.endDate = DateUtil.parse(date, "yyyy/MM/dd HH:mm");
	}
	
	public void setDueDate(String date){
		this.dueDate = DateUtil.parse(date, "yyyy/MM/dd");
	}

	public String getEventInfo() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		StringBuilder sb = new StringBuilder();
		sb.append("イベント名：");
		sb.append(this.name);
		sb.append(System.lineSeparator());
		sb.append("start：");
		sb.append(sdf.format(startDate));
		sb.append(System.lineSeparator());
		sb.append("end：");
		sb.append(sdf.format(endDate));
		return sb.toString();
	}
}
