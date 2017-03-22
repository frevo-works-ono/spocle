package com.spocle.domain.model.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "teams")
@Data
public class Team {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String name;

  @Column(name = "establish_date")
  private Date establishDate;

  @Column
  private String category;

  @Column
  private String level;

  @Column
  private String activityPlace;

  @Column
  private String activityDate;

  @OneToMany
  private List<Member> members;

  @OneToMany
  private List<Event> events;

  @Column
  private String domain;
}
