package com.cg.ams.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ams.entity.StudentEntity;
import com.cg.ams.respository.IStudentRepository;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	IStudentRepository stdRepo;

	@Override
	public long add(StudentEntity entity) {

		StudentEntity std = stdRepo.save(entity);

		return std.getId();
	}

	@Override
	public void update(StudentEntity entity) {

		StudentEntity std = stdRepo.findById(entity.getId());
		if (std != null) {
			stdRepo.save(entity);
		}

	}

	@Override
	public void delete(StudentEntity entity) {

		stdRepo.delete(entity);

	}

	@Override
	public StudentEntity findByPk(long id) {

		StudentEntity std = stdRepo.findById(id);
		return std;
	}

	@Override
	public List<StudentEntity> search(StudentEntity entity, long pageNo, int pageSize) {

		return null;
	}

	@Override
	public List<StudentEntity> search(StudentEntity entity) {

		return null;
	}

	@Override
	public List<StudentEntity> findByName(String firstName) {
		return stdRepo.findByFirstName(firstName);
	}

}
