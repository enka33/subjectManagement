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
			return "����Ŀ���ơ��޸ĳɹ���";
		} else if(subjectReturnInfo.getChangeCell().equals("subjectComplex")) {//�ģ�subjectComplexû����SubjectInfo�е�complex���Ӧ��������ξ���
			if(subjectReturnInfo.getSubjectComplex().equals("0")) {
				subjectDao.modifyDataInSubjectInfoTable(subjectId, "complex", subjectReturnInfo.getSubjectComplex());
				subjectRelationDao.deleteDataInSubjectRelationTable(subjectId);
				return "�޸ĳɹ������޸�Ϊ��һ��Ŀ��";
			} else if(subjectReturnInfo.getSubjectComplex().equals("1")) {
				return "�����·������ѡ���Ӧ�Ŀ�Ŀ��";
			}
		} else if(subjectReturnInfo.getChangeCell().equals("subjectStatus")) {
			subjectDao.modifyDataInSubjectInfoTable(subjectId, subjectReturnInfo.getChangeCell(), subjectReturnInfo.getSubjectStatus());
			return "����Ŀ״̬���޸ĳɹ���";
		}else if(subjectReturnInfo.getChangeCell().equals("1>1")) {
			subjectRelationDao.deleteDataInSubjectRelationTable(subjectId);
			for(String singleSubjectId : subjectReturnInfo.getSubjectRelation()) {
				SubjectRelationInfo subjectRelationInfo = new SubjectRelationInfo();
				subjectRelationInfo.setComplexSubjectId(subjectId);
				subjectRelationInfo.setMappingSubjectId(singleSubjectId);
				subjectRelationDao.addDataToTableSubjectRelationInfo(subjectRelationInfo);
			}
			return "��Ŀ���϶�Ӧ��ϵ�޸ĳɹ���";
		} else if(subjectReturnInfo.getChangeCell().equals("0>1")) {
			subjectDao.modifyDataInSubjectInfoTable(subjectId, "complex", subjectReturnInfo.getSubjectComplex());
			for(String singleSubjectId : subjectReturnInfo.getSubjectRelation()) {
				SubjectRelationInfo subjectRelationInfo = new SubjectRelationInfo();
				subjectRelationInfo.setComplexSubjectId(subjectId);
				subjectRelationInfo.setMappingSubjectId(singleSubjectId);
				subjectRelationDao.addDataToTableSubjectRelationInfo(subjectRelationInfo);
			}
			return "��һ��Ŀ�ɹ��޸�Ϊ���Ͽ�Ŀ��";
		}
		return null;
	}
}
