package com.learn.indexapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.indexapi.entities.LinkHomePage;

@Repository
public interface ILinkHomePageRepository extends JpaRepository<LinkHomePage, Long>{

}
