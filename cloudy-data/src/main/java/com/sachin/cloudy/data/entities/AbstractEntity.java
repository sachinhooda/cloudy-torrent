package com.sachin.cloudy.data.entities;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by sachinhooda on 18/2/17.
 */
@MappedSuperclass

public abstract class AbstractEntity implements Serializable {

  private static final long serialVersionUID = -4988373185353252311L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Long id;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || !(o instanceof AbstractEntity))
      return false;

    AbstractEntity that = (AbstractEntity) o;

    if (id == null) {
      if (that.id != null) {
        return false;
      }
    } else if (!id.equals(that.id)) {
      return false;
    }
    return true;

  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }

  @Override
  public String toString() {
    return "Entity [id=" + id + ", getId()=" + getId() + ", hashCode()=" + hashCode()
        + ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
  }
}
