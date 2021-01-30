package com.learn.indexapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.learn.indexapi.constant.SequenceConst;
import com.learn.indexapi.entities.HomeLinkEntity;

@Repository
public interface IHomeLinkRepository extends JpaRepository<HomeLinkEntity, Long>{
	
	List<HomeLinkEntity> findByOrderBySortOrderAsc();
	
	void deleteById(Long id);
	
//	HomeLinkEntity findFirstByOrderByIdDesc();
	
	@Query(value = "SELECT nextval('" + SequenceConst.SEQUENCE_HOME_LINK_ID +  "')", nativeQuery = true)
    Long getNextSequenceId();
}
