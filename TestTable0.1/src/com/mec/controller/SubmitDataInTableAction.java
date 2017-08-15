package com.mec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mec.model.SubjectReturnInfo;
import com.mec.service.SubmitSubjectInfoService;

@Controller
public class SubmitDataInTableAction {
	@Autowired
	private SubmitSubjectInfoService submitSubjectInfoService;
	
	@RequestMapping(value="/Editable/Edit")
	@ResponseBody
	public String getDataFromOnstage(SubjectReturnInfo subjectReturnInfo) {
		submitSubjectInfoService.setSubjectReturnInfo(subjectReturnInfo);
		submitSubjectInfoService.submitDataToSubjectInfo();
		
		return "{\"1\":\"QW\"}";
	}
}
