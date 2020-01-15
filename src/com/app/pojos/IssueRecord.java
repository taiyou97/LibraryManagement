package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
public class IssueRecord {
	private Integer id;
	private LocalDate issue_date, return_duedate, return_date;
	private float fine_amount;
	private Copies copyId;
	private Users memberid;
	
	public IssueRecord() {
		// TODO Auto-generated constructor stub
		System.out.println("IssueRecord()");
	}
	
	public IssueRecord(LocalDate issue_date, LocalDate return_duedate, LocalDate return_date, float fine_amount) {
		super();
		this.issue_date = issue_date;
		this.return_duedate = return_duedate;
		this.return_date = return_date;
		this.fine_amount = fine_amount;
	}
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getIssue_date() {
		return issue_date;
	}

	public void setIssue_date(LocalDate issue_date) {
		this.issue_date = issue_date;
	}

	public LocalDate getReturn_duedate() {
		return return_duedate;
	}

	public void setReturn_duedate(LocalDate return_duedate) {
		this.return_duedate = return_duedate;
	}

	public LocalDate getReturn_date() {
		return return_date;
	}

	public void setReturn_date(LocalDate return_date) {
		this.return_date = return_date;
	}

	public float getFine_amount() {
		return fine_amount;
	}

	public void setFine_amount(float fine_amount) {
		this.fine_amount = fine_amount;
	}

	@ManyToOne
	@JoinColumn(name = "copy_Id")
	public Copies getCopyId() {
		return copyId;
	}

	public void setCopyId(Copies copyId) {
		this.copyId = copyId;
	}

	@ManyToOne
	@JoinColumn(name = "memberid")
	public Users getMemberid() {
		return memberid;
	}

	public void setMemberid(Users memberid) {
		this.memberid = memberid;
	}

	@Override
	public String toString() {
		return "IssueRecord [id=" + id + ", issue_date=" + issue_date + ", return_duedate=" + return_duedate
				+ ", return_date=" + return_date + ", fine_amount=" + fine_amount + "]";
	}

}
