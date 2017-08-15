package com.mec.model;

import java.util.ArrayList;

public class SubjectReturnInfo {
	private String subjectId;
	private String subjectName;
	private String subjectComplex;
	private ArrayList<String> subjectRelation;
	private String subjectStatus;
	
	private String changeCell;
	
	public SubjectReturnInfo() {
	}

	public SubjectReturnInfo(String subjectId, String subjectName, String subjectComplex,
			ArrayList<String> subjectRelation, String subjectStatus) {
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.subjectComplex = subjectComplex;
		this.subjectRelation = subjectRelation;
		this.subjectStatus = subjectStatus;
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

	public String getSubjectComplex() {
		return subjectComplex;
	}

	public void setSubjectComplex(String subjectComplex) {
		this.subjectComplex = subjectComplex;
	}

	public ArrayList<String> getSubjectRelation() {
		return subjectRelation;
	}

	public void setSubjectRelation(ArrayList<String> subjectRelation) {
		this.subjectRelation = subjectRelation;
	}

	public String getSubjectStatus() {
		return subjectStatus;
	}

	public void setSubjectStatus(String subjectStatus) {
		this.subjectStatus = subjectStatus;
	}

	public String getChangeCell() {
		return changeCell;
	}

	public void setChangeCell(String changeCell) {
		this.changeCell = changeCell;
	}

	@Override
	public String toString() {
		return "SubjectReturnInfo [subjectId=" + subjectId + ", subjectName=" + subjectName + ", subjectComplex="
				+ subjectComplex + ", subjectRelation=" + subjectRelation + ", subjectStatus=" + subjectStatus
				+ ", changeCell=" + changeCell + "]";
	}
}
