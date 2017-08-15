package com.mec.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mec.model.SubjectRelationInfo;

@Component
@Transactional
public class SubjectRelationDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public SubjectRelationDao() {
	}
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public List<SubjectRelationInfo> getSubjectRelation() {
		Session session = this.getSession();
		@SuppressWarnings("unchecked")
		List<SubjectRelationInfo> list = session.createQuery("from SubjectRelationInfo").getResultList();  
		return list;
	}
	
	public void deleteDataInSubjectRelationTable(String subjectId) {
		String hql="delete from SubjectRelationInfo subjectRelationInfo where subjectRelationInfo.complexSubjectId='" + subjectId + "'";
		Query<?> query = this.getSession().createQuery(hql);
		query.executeUpdate();
	}
	
	public void addDataToTableSubjectRelationInfo(SubjectRelationInfo subjectRelationInfo) {
		this.getSession().save(subjectRelationInfo);
	}


}
