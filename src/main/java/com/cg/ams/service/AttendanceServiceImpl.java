package com.cg.ams.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ams.entity.AttendanceEntity;
import com.cg.ams.respository.IAttendanceRepository;

@Service
public class AttendanceServiceImpl implements IAttendanceService {

	@Autowired
	IAttendanceRepository attRepo;

	@Override
	public AttendanceEntity add(AttendanceEntity entity) {
		AttendanceEntity att = attRepo.save(entity);
		att.setId(att.getId());
		att.setSubjectId(att.getSubjectId());
		att.setSubjectName(att.getSubjectName());
		att.setStudentId(att.getStudentId());
		att.setStudentName(att.getStudentName());
		att.setSemester(att.getSemester());
		att.setDate(att.getDate());
		att.setTotalClass(att.getTotalClass());
		att.setStatus(att.getStatus());
		att.setTotal(att.getTotal());
		att.setPercentage(att.getPercentage());
		att.setCourseId(att.getCourseId());
		att.setCourseName(att.getCourseName());

		return att;
	}

	@Override
	public void update(AttendanceEntity entity) {

		attRepo.save(entity);

	}

	@Override
	public void delete(AttendanceEntity entity) {
		// TODO Auto-generated method stub
		attRepo.delete(entity);

	}

	@Override
	public AttendanceEntity findByName(String student_name) {
		return attRepo.findByAttName(student_name);

	}

	@Override
	public AttendanceEntity findByPk(long id) {
		AttendanceEntity att = attRepo.getById(id);
		return att;
	}

	@Override
	public List<AttendanceEntity> search(AttendanceEntity entity, long pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AttendanceEntity> search(AttendanceEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}
}
