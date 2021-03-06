package com.learn.indexapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.indexapi.entities.HomeLinkDetailEntity;

@Repository
public interface IHomeLinkDetailRepository extends JpaRepository<HomeLinkDetailEntity, Long>{

}
