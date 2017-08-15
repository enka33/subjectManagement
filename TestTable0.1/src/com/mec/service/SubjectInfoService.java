package com.mec.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mec.dao.SubjectDao;
import com.mec.dao.SubjectRelationDao;
import com.mec.model.SubjectInfo;
import com.mec.model.SubjectRelationInfo;
import com.mec.model.SubjectReturnInfo;

@Service
public class SubjectInfoService {
	@Autowired
	private SubjectDao subjectDao;
	@Autowired
	private SubjectRelationDao subjectRelationDao;
	
	//private Map<String, ArrayList<SubjectReturnInfo>> subjectInfoMap;
	
	public SubjectInfoService() {
	}
	
	public ArrayList<SubjectReturnInfo> getSubjectInfo() {
		ArrayList<SubjectReturnInfo> subjectReturnInfoList = new ArrayList<SubjectReturnInfo>();
		
		List<SubjectInfo> subjectInfoList = subjectDao.getSubject();
		List<SubjectRelationInfo> subjectRelationInfoList = subjectRelationDao.getSubjectRelation();
		
		Map<String, ArrayList<String>> subjectRelationMap = new HashMap<String, ArrayList<String>>();
		for(SubjectRelationInfo subjectRelationInfo :subjectRelationInfoList) {
			ArrayList<String> singleSubjectList = null;
			if(subjectRelationMap.get(subjectRelationInfo.getComplexSubjectId()) == null) {
				singleSubjectList = new ArrayList<String>();
				singleSubjectList.add(subjectRelationInfo.getMappingSubjectId());
				subjectRelationMap.put(subjectRelationInfo.getComplexSubjectId(), singleSubjectList);
			} else {
				ArrayList<String> temp = subjectRelationMap.get(subjectRelationInfo.getComplexSubjectId());
				temp.add(subjectRelationInfo.getMappingSubjectId());
			}
		}
		
		SubjectReturnInfo subjectReturnInfo = null;
		for(SubjectInfo subjectInfo : subjectInfoList) {
			ArrayList<String> singleSubjectSet = new ArrayList<String>();
			
			String subjectId = subjectInfo.getSubjectId();
			String subjectName = subjectInfo.getSubjectName();
			String subjectComplex = subjectInfo.getComplex();
			String subjectStatus = subjectInfo.getSubjectStatus();
			
			if(subjectRelationMap.get(subjectId) == null) {
				singleSubjectSet.add(subjectId);
			} else {
				singleSubjectSet = subjectRelationMap.get(subjectId);
			}
			subjectReturnInfo = new SubjectReturnInfo(subjectId, subjectName, subjectComplex, singleSubjectSet, subjectStatus);
			subjectReturnInfoList.add(subjectReturnInfo);
		}
		return subjectReturnInfoList;
	}

}
