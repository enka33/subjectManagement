package com.mec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mec.dao.SubjectDao;
import com.mec.dao.SubjectRelationDao;
import com.mec.model.SubjectRelationInfo;
import com.mec.model.SubjectReturnInfo;

@Service
public class ModifyDataService {
	@Autowired
	private SubjectDao subjectDao;
	@Autowired
	private SubjectRelationDao subjectRelationDao;
	
	public ModifyDataService() {
	}
	
	public String modifyData(SubjectReturnInfo subjectReturnInfo) {
		String subjectId = subjectReturnInfo.getSubjectId();
		if(subjectReturnInfo.getChangeCell().equals("subjectName")) {
			subjectDao.modifyDataInSubjectInfoTable(subjectId, subjectReturnInfo.getChangeCell(), subjectReturnInfo.getSubjectName());
			return "《科目名称》修改成功！";
		} else if(subjectReturnInfo.getChangeCell().equals("subjectComplex")) {//改：subjectComplex没有与SubjectInfo中的complex相对应，造成尴尬局面
			if(subjectReturnInfo.getSubjectComplex().equals("0")) {
				subjectDao.modifyDataInSubjectInfoTable(subjectId, "complex", subjectReturnInfo.getSubjectComplex());
				subjectRelationDao.deleteDataInSubjectRelationTable(subjectId);
				return "修改成功，已修改为单一科目！";
			} else if(subjectReturnInfo.getSubjectComplex().equals("1")) {
				return "请在下方面板中选择对应的科目！";
			}
		} else if(subjectReturnInfo.getChangeCell().equals("subjectStatus")) {
			subjectDao.modifyDataInSubjectInfoTable(subjectId, subjectReturnInfo.getChangeCell(), subjectReturnInfo.getSubjectStatus());
			return "《科目状态》修改成功！";
		}else if(subjectReturnInfo.getChangeCell().equals("1>1")) {
			subjectRelationDao.deleteDataInSubjectRelationTable(subjectId);
			for(String singleSubjectId : subjectReturnInfo.getSubjectRelation()) {
				SubjectRelationInfo subjectRelationInfo = new SubjectRelationInfo();
				subjectRelationInfo.setComplexSubjectId(subjectId);
				subjectRelationInfo.setMappingSubjectId(singleSubjectId);
				subjectRelationDao.addDataToTableSubjectRelationInfo(subjectRelationInfo);
			}
			return "科目复合对应关系修改成功！";
		} else if(subjectReturnInfo.getChangeCell().equals("0>1")) {
			subjectDao.modifyDataInSubjectInfoTable(subjectId, "complex", subjectReturnInfo.getSubjectComplex());
			for(String singleSubjectId : subjectReturnInfo.getSubjectRelation()) {
				SubjectRelationInfo subjectRelationInfo = new SubjectRelationInfo();
				subjectRelationInfo.setComplexSubjectId(subjectId);
				subjectRelationInfo.setMappingSubjectId(singleSubjectId);
				subjectRelationDao.addDataToTableSubjectRelationInfo(subjectRelationInfo);
			}
			return "单一科目成功修改为复合科目！";
		}
		return null;
	}
}
