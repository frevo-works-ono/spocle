package com.spocle.domain.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "events")
@Data
public class Event {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column
  private String name;
  @Column(name = "start_date")
  private Date startDate;
  @Column(name = "end_date")
  private Date endDate;
  private String detail;
  @Column(name = "due_date")
  private Date dueDate;
  @ManyToOne
  private Team team;
}
