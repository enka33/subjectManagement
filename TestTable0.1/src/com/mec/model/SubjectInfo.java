package com.mec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mec_base_subject_info")
public class SubjectInfo {
	@Id
	@Column(name="id")
	private String subjectId;
	@Column(name="name")
	private String subjectName;
	@Column(name="status")
	private String subjectStatus;
	@Column(name="complex")
	private String complex;
	
	public SubjectInfo() {
	}

	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjectStatus() {
		return subjectStatus;
	}

	public void setSubjectStatus(String subjectStatus) {
		this.subjectStatus = subjectStatus;
	}

	public String getComplex() {
		return complex;
	}

	public void setComplex(String complex) {
		this.complex = complex;
	}

	@Override
	public String toString() {
		return "SubjectInfo [subjectId=" + subjectId + ", subjectName=" + subjectName + ", subjectStatus="
				+ subjectStatus + ", complex=" + complex + "]";
	}

}
