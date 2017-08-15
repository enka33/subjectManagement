package com.mec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mec.model.SubjectReturnInfo;
import com.mec.service.ModifyDataService;

@Controller
public class ModifyDataAction {
	@Autowired
	private ModifyDataService modifyDataService;
	
	public ModifyDataAction() {
	}
	
	@RequestMapping(value="/modify",produces = "application/json;charset=utf-8")
	@ResponseBody
	public String getData(SubjectReturnInfo subjectReturnInfo) {
		System.out.println("율율율율");
		System.out.println(subjectReturnInfo);
		String str = modifyDataService.modifyData(subjectReturnInfo);
		System.out.println("return modify: " + str);
		return str;
	}
}
