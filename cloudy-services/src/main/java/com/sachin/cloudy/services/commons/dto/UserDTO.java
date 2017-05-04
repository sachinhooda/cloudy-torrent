package com.sachin.cloudy.services.commons.dto;

import com.sachin.cloudy.data.entities.User;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by sachinhooda on 14/3/17.
 */
public class UserDTO {

  private Long id;

  @NotNull
  @NotBlank
  @NotEmpty
  private String firstName;

  @NotNull
  @NotBlank
  @NotEmpty
  private String lastName;

  @Email
  @NotNull
  @NotBlank
  @NotEmpty
  private String email;

  private String password;

  private String gender;

  private String birthDate;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

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

  public static User fromDTO(User user, UserDTO userDTO) {

    if (user == null) {
      user = new User();
    }

    user.setFirstName(userDTO.getFirstName());
    user.setLastName(userDTO.getLastName());
    user.setEmail(userDTO.getEmail());
    if (userDTO.getBirthDate() != null) {
      user.setBirthDate(userDTO.getBirthDate());
    }
    if (userDTO.getGender() != null) {
      user.setGender(userDTO.getGender());
    }
    if (userDTO.getPassword() != null)
      user.setPassword(userDTO.getPassword());


    return user;
  }

  public static UserDTO toDTO(User user) {
    UserDTO userDTO = new UserDTO();
    userDTO.setId(user.getId());
    userDTO.setFirstName(user.getFirstName());
    userDTO.setLastName(user.getLastName());
    userDTO.setGender(user.getGender());
    userDTO.setBirthDate(user.getBirthDate());
    userDTO.setEmail(user.getEmail());

    return userDTO;
  }
}
