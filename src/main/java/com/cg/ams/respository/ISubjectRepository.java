package com.cg.ams.respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ams.entity.SubjectEntity;

@Repository
public interface ISubjectRepository extends JpaRepository<SubjectEntity, Long> {
	public Optional<SubjectEntity> findById(long id);

	public Optional<SubjectEntity> findByName(String name);

}
