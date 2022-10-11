package com.nt.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class SeasonFinderMgmtImpl implements ISeasonFinderMgmt {

	@Override
	public String findSeason() {
		LocalDateTime ldt = LocalDateTime.now();
		int month = ldt.getMonthValue();
		
		if(month >=7 && month<=9)
		{
			return "Rainy Season";
		}
		else if(month >=4 && month <7) {
			return "Summer Season";
		}
		else {
			return "Winter Season";
		}
	}

}
