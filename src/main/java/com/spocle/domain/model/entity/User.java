package com.spocle.domain.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User implements Serializable{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column
  private String name;
  @Column(name="mailaddress")
  private String mailAddress;
  @Column
  private String password;
  @Column(name = "temp_key")
  private String tempKey;
  @Column(name = "line_id")
  private String lineId;

}
