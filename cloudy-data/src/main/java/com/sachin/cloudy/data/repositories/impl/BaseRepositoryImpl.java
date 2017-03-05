package com.sachin.cloudy.data.repositories.impl;

import com.sachin.cloudy.data.repositories.BaseRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.QueryDslJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * Created by sachinhooda on 18/2/17.
 */
public class BaseRepositoryImpl<T, ID extends Serializable> extends QueryDslJpaRepository<T, ID>
    implements BaseRepository<T, ID> {

  private final EntityManager entityManager;

  public BaseRepositoryImpl(JpaEntityInformation<T, ID> entityInformation,
      EntityManager entityManager) {
    super(entityInformation, entityManager);
    this.entityManager = entityManager;
  }
}
