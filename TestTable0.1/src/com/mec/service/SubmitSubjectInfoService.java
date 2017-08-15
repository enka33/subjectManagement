package com.mec.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mec.dao.SubjectDao;
import com.mec.dao.SubjectRelationDao;
import com.mec.model.SubjectInfo;
import com.mec.model.SubjectRelationInfo;
import com.mec.model.SubjectReturnInfo;

@Service
public class SubmitSubjectInfoService {
	@Autowired
	private SubjectDao subjectDao;
	@Autowired
	private SubjectRelationDao subjectRelationDao;
	private SubjectReturnInfo subjectReturnInfo;
	private String subjectId;
	private ArrayList<String> subjectRelation;
	
	public SubmitSubjectInfoService() {
	}
	
	public void setSubjectReturnInfo(SubjectReturnInfo subjectReturnInfo) {
		this.subjectReturnInfo = subjectReturnInfo;
	}

	public void submitDataToSubjectInfo() {
		SubjectInfo subjectInfo = new SubjectInfo();
		subjectId = subjectReturnInfo.getSubjectId();
		subjectRelation = subjectReturnInfo.getSubjectRelation();
		String subjectComplex = subjectReturnInfo.getSubjectComplex();
		subjectInfo.setSubjectId(subjectId);
		subjectInfo.setSubjectName(subjectReturnInfo.getSubjectName());
		subjectInfo.setSubjectStatus(subjectReturnInfo.getSubjectStatus());
		subjectInfo.setComplex(subjectComplex);
		subjectDao.addDataToTableSubjectInfo(subjectInfo);
		if(subjectComplex.equals("1")) {
			submitDataToSubjectRelation();
		}
		
	}
	
	private void submitDataToSubjectRelation() {
		for(String id : subjectRelation) {
			SubjectRelationInfo subjectRelationInfo = new SubjectRelationInfo();
			subjectRelationInfo.setComplexSubjectId(subjectId);
			subjectRelationInfo.setMappingSubjectId(id);
			subjectRelationDao.addDataToTableSubjectRelationInfo(subjectRelationInfo);
		}
	}
}
