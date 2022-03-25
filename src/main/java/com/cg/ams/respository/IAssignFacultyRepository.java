package com.cg.ams.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ams.entity.AssignFacultyEntity;

@Repository
public interface IAssignFacultyRepository extends JpaRepository<AssignFacultyEntity, Long> {

}
