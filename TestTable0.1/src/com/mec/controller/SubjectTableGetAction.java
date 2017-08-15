package com.mec.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mec.model.SubjectReturnInfo;
import com.mec.service.SubjectInfoService;

@Controller
public class SubjectTableGetAction {
	@Autowired
	private SubjectInfoService subjectInfoService;

	public SubjectTableGetAction() {
	}
	
	@RequestMapping(value="/querySubject")
	@ResponseBody
	public ArrayList<SubjectReturnInfo> getTable() {
		return subjectInfoService.getSubjectInfo();
	}
	
}
