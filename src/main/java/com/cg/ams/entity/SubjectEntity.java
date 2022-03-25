package com.cg.ams.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Entity
@Data
@Table(name = "subject")
public class SubjectEntity {
	@Id
	// @NotEmpty(message="Id cannot be a null value")
	private long id;
	// private long courseId;
	// private String courseName;
	@NotEmpty(message = "Name shouldn't be empty")
	private String name;
	@NotEmpty(message = "subjectCode shouldn't be empty")
	@Length(min = 2, max = 6)
	private String subjectCode;
	@NotEmpty(message = "Semester shouldn't be empty")
	private String semester;
	// private String description;

	@ManyToOne(cascade = CascadeType.ALL)
	private CourseEntity course;
}
