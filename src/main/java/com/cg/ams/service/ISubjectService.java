package com.cg.ams.service;

import java.util.List;

import com.cg.ams.entity.SubjectEntity;
import com.cg.ams.exception.RecordNotFoundException;

public interface ISubjectService {
	public long add(SubjectEntity entity);

	public void update(SubjectEntity entity) throws RecordNotFoundException;

	public void delete(SubjectEntity entity) throws RecordNotFoundException;

	public SubjectEntity findByName(String name) throws Exception;

	public SubjectEntity findByPk(long id) throws RecordNotFoundException;

	public List<SubjectEntity> search(SubjectEntity entity, long pageNo, int pageSize);

	public List<SubjectEntity> search(SubjectEntity entity);

	public List<SubjectEntity> getAllSubjects();
}
