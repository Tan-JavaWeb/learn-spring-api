package com.learn.indexapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.indexapi.entities.LinkHomePageDetail;

@Repository
public interface ILinkHomePageDetailRepository extends JpaRepository<LinkHomePageDetail, Long>{

}
