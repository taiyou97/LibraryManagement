package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Copies {
	private Integer id;
	private int rack;
	private boolean status;
	private Books bookid;
	private List<IssueRecord> issueRecords = new ArrayList<IssueRecord>();
	
	public Copies() {
		// TODO Auto-generated constructor stub
		System.out.println("Copies()");
	}

	public Copies(int rack, boolean status) {
		super();
		this.rack = rack;
		this.status = status;
	}

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getRack() {
		return rack;
	}

	public void setRack(int rack) {
		this.rack = rack;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@ManyToOne
	@JoinColumn(name = "book_Id")
	public Books getBookid() {
		return bookid;
	}

	public void setBookid(Books bookid) {
		this.bookid = bookid;
	}

	@OneToMany(mappedBy = "copyId", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<IssueRecord> getIssueRecords() {
		return issueRecords;
	}

	public void setIssueRecords(List<IssueRecord> issueRecords) {
		this.issueRecords = issueRecords;
	}
	
	public void addIssueRecords(IssueRecord record) {
		issueRecords.add(record);
		record.setCopyId(this);
	}
	
	public void removeIssueRecords(IssueRecord record) {
		issueRecords.remove(record);
		record.setCopyId(null);
	}

	@Override
	public String toString() {
		return "Copies [id=" + id + ", rack=" + rack + ", status=" + status + "]";
	}
	
}
