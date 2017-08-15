package com.mec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mec_base_subject_relation")
public class SubjectRelationInfo {
	@Id
	@Column(name="id", unique=true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int subjectRelationId;
	@Column(name="complex_base_subject_id")
	private String complexSubjectId;
	@Column(name="base_subject_id")
	private String mappingSubjectId;
	
	public SubjectRelationInfo() {
	}

	public int getSubjectRelationId() {
		return subjectRelationId;
	}

	public void setSubjectRelationId(int subjectRelationId) {
		this.subjectRelationId = subjectRelationId;
	}

	public String getComplexSubjectId() {
		return complexSubjectId;
	}

	public void setComplexSubjectId(String complexSubjectId) {
		this.complexSubjectId = complexSubjectId;
	}

	public String getMappingSubjectId() {
		return mappingSubjectId;
	}

	public void setMappingSubjectId(String mappingSubjectId) {
		this.mappingSubjectId = mappingSubjectId;
	}
}
