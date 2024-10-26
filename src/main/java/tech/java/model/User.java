package tech.java.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;


public class User implements Serializable {

  private static final long serialVersionUID = 31L;

  private String username;
  private Integer userId;
  private String password;
  //if any specific format required here then we have to create custom InstantSerializer and
  // InstantDeserializer
  @JsonFormat (shape = JsonFormat.Shape.STRING)
  private Instant dob;


  public User (String username, Integer userId, String password, Instant dob) {
    this.username = username;
    this.userId = userId;
    this.password = password;
    this.dob = dob;
  }

  public User () {
  }

  public String getUsername () {
    return username;
  }

  public void setUsername (String username) {
    this.username = username;
  }

  public Integer getUserId () {
    return userId;
  }

  public void setUserId (Integer userId) {
    this.userId = userId;
  }

  public String getPassword () {
    return password;
  }

  public void setPassword (String password) {
    this.password = password;
  }

  public Instant getDob () {
    return dob;
  }

  public void setDob (Instant dob) {
    this.dob = dob;
  }

  @Override
  public String toString () {
    return "User{" +
           "username='" + username + '\'' +
           ", userId=" + userId +
           ", password='" + password + '\'' +
           ", dob=" + dob +
           '}';
  }
}
