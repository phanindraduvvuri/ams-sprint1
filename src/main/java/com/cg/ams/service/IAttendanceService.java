package com.cg.ams.service;

import java.util.List;

import com.cg.ams.entity.AttendanceEntity;


public interface IAttendanceService {
	AttendanceEntity add(AttendanceEntity entity);

    void update(AttendanceEntity entity);

    void delete(AttendanceEntity entity);

    AttendanceEntity findByName(String student_name);

    AttendanceEntity findByPk(long id);

    List<AttendanceEntity> search(AttendanceEntity entity, long pageNo, int pageSize);

    List<AttendanceEntity> search(AttendanceEntity entity);
}
