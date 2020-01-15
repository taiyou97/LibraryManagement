package com.app.pojos;

import java.time.LocalDate;

public class IssueRecord {
	private Integer id;
	private LocalDate issue_date, return_duedate, return_date;
	private float fine_amount;
	
	public IssueRecord() {
		// TODO Auto-generated constructor stub
		System.out.println("IssueRecord()");
	}
}
