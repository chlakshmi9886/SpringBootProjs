package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.service.ISeasonFinderMgmt;

@Controller
public class SeasonFinderOperationController {

	@Autowired
	private ISeasonFinderMgmt service;
	
	@RequestMapping
	public String showHome() {
		return "welcom";
	}
	
	@RequestMapping("/season")
	public String findSeason(Map<String, Object> map) {
		String msg = service.findSeason();
		map.put("season", msg);
		return "show_season";
	}
	
	@RequestMapping({"/report","/report2","/report3"})
	public String showReport() {
		System.out.println("SeasonFinderOperationController.showReport()");
		return "show_report";
	}
	
	@RequestMapping("/REPORT1")
	public String showReport1() {
		System.out.println("SeasonFinderOperationController.showReport1()");
		return "show_report1";
	}
	
}
