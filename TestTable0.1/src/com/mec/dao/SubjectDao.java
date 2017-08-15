package com.mec.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mec.model.SubjectInfo;

@Component
@Transactional
public class SubjectDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public SubjectDao() {
	}
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public List<SubjectInfo> getSubject() {
		Session session = this.getSession();
		@SuppressWarnings("unchecked")
		List<SubjectInfo> list = session.createQuery("from SubjectInfo").getResultList();  
		return list;
	}
	
	public void modifyDataInSubjectInfoTable(String subjectId, String updateKey, String updateValue) {
		String hql="update SubjectInfo subjectInfo set subjectInfo." + updateKey + "='" + updateValue + "' where subjectInfo.subjectId='" + subjectId + "'";
		System.out.println("hql: " + hql);
		Query<?> query = this.getSession().createQuery(hql);
		query.executeUpdate();
	}
	
	public void addDataToTableSubjectInfo(SubjectInfo subjectInfo) {
		this.getSession().save(subjectInfo);
	}
}
