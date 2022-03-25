package com.cg.ams.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ams.entity.CourseEntity;

@Repository
public interface ICourseRepository extends JpaRepository<CourseEntity, Long> {
	CourseEntity findByName(String name);
}
