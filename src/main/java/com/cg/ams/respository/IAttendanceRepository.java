package com.cg.ams.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.ams.entity.AttendanceEntity;

@Repository
public interface IAttendanceRepository extends JpaRepository<AttendanceEntity, Long> {
	@Query(value = "select attendance.* from attendance where attendance.student_name=:student_name", nativeQuery = true)
	AttendanceEntity findByAttName(@Param("student_name") String student_name);

}
