package com.sachin.cloudy.data.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by sachinhooda on 18/2/17.
 */

@Entity
@Table(name = "USERS")
public class User extends AuditableEntity {


  private static final long serialVersionUID = 8297129479995182370L;
  @Column(name = "FIRST_NAME")
  private String firstName;

  @Column(name = "LAST_NAME")
  private String lastName;

  @Column(name = "EMAIL")
  private String email;

  @Column(name = "PASSWORD")
  private String password;

  @Column(name = "GENDER")
  private String gender;

  @Column(name = "BIRTH_DATE")
  private String birthDate;

  @JoinColumn(name = "DATA_USAGE_STATS_ID")
  @OneToOne(cascade = CascadeType.ALL)
  private DataUsageStats dataUsageStats;

  @OneToMany(mappedBy = "torrentUser")
  private List<TorrentsUsageStats> torrentsUsageStats;


  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
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

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(String birthDate) {
    this.birthDate = birthDate;
  }

  public DataUsageStats getDataUsageStats() {
    return dataUsageStats;
  }

  public void setDataUsageStats(DataUsageStats dataUsageStats) {
    this.dataUsageStats = dataUsageStats;
  }

  public List<TorrentsUsageStats> getTorrentsUsageStats() {
    return torrentsUsageStats;
  }

  public void setTorrentsUsageStats(List<TorrentsUsageStats> torrentsUsageStats) {
    this.torrentsUsageStats = torrentsUsageStats;
  }
}
