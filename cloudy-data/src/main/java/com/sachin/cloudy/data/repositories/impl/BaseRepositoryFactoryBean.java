package com.sachin.cloudy.data.repositories.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * Created by sachinhooda on 25/2/17.
 */
public class BaseRepositoryFactoryBean<R extends JpaRepository<T, I>, T, I extends Serializable>
    extends JpaRepositoryFactoryBean<R, T, I> {

  public BaseRepositoryFactoryBean(Class<? extends R> repositoryInterface) {
    super(repositoryInterface);
  }

  @Override
  protected RepositoryFactorySupport createRepositoryFactory(EntityManager em) {
    return new BaseRepositoryFactory<T, I>(em);
  }

  private static class BaseRepositoryFactory<T, I extends Serializable> extends
      JpaRepositoryFactory {

    private final EntityManager entityManager;

    public BaseRepositoryFactory(EntityManager entityManager) {
      super(entityManager);
      this.entityManager = entityManager;

    }

    @SuppressWarnings("unchecked")
    @Override
    protected Object getTargetRepository(RepositoryInformation information) {
      JpaEntityInformation<T, I> entityInformation =
          (JpaEntityInformation<T, I>) getEntityInformation(information.getDomainType());
      return new BaseRepositoryImpl<T, I>(entityInformation, entityManager);
    }

    @Override
    protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
      return BaseRepositoryImpl.class;
    }
  }
}
