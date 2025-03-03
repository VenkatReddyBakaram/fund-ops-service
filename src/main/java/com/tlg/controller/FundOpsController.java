package com.tlg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tlg.entities.Institution;
import com.tlg.service.FundOpsService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("fundops/")
@Slf4j
public class FundOpsController {

	@Autowired
	private FundOpsService fundOpsService;

	@PostMapping("insertInstitution")
	@ResponseBody
	@ResponseStatus(code = HttpStatus.OK)
	public String insertInstitution(@RequestBody Institution institution) {
		log.info("FundOpsServiceImpl : {} {} ", institution.getInstitutionId(), institution.getInstitutionName());
		fundOpsService.insertInstitution(institution.getInstitutionId(), institution.getInstitutionName());
		return "Stored Procedure processed Successfully....!";
	}
}
