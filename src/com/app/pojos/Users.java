package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Users {
	private Integer id;
	private String name, email;
	private Long phone;
	private String passwd;
	private UsersType role;
	private List<Payments> payments = new ArrayList<Payments>();
	private List<IssueRecord> issueRecords = new ArrayList<IssueRecord>();
	
	//INSERT INTO Users (email, name, passwd, phone, role) VALUES ("Shweta@gmail.com", "Shweta Sah", 1234, 8223087766, "OWNER");
	//INSERT INTO Users (email, name, passwd, phone, role) VALUES ("Praveen@gmail.com", "Praveen Shah", 1234, 7587042615, "USER");
	//INSERT INTO Users (email, name, passwd, phone, role) VALUES ("Aman@gmail.com", "Aman Singh", 1234, 7974458776, "LIBRARIAN");
	
	public Users() {
		// TODO Auto-generated constructor stub
		System.out.println("Users()");
	}

	public Users(String name, String email, Long phone, String password, UsersType role) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.passwd = password;
		this.role = role;
	}

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(length = 30)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(length = 30)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	@Column(length = 30)
	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	public UsersType getRole() {
		return role;
	}

	public void setRole(UsersType role) {
		this.role = role;
	}
	
	@OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Payments> getPayments() {
		return payments;
	}

	public void setPayments(List<Payments> payments) {
		this.payments = payments;
	}
	
	public void addPayments(Payments p) {
		payments.add(p);
		p.setUserId(this);
	}
	
	public void removePayments(Payments p) {
		payments.remove(p);
		p.setUserId(null);
	}

	@OneToMany(mappedBy = "memberid", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<IssueRecord> getIssueRecords() {
		return issueRecords;
	}

	public void setIssueRecords(List<IssueRecord> issueRecords) {
		this.issueRecords = issueRecords;
	}

	public void addIssueRecords(IssueRecord record) {
		issueRecords.add(record);
		record.setMemberid(this);
	}
	
	public void removeIssueRecords(IssueRecord record) {
		issueRecords.remove(record);
		record.setMemberid(null);
	}
	
	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", password=" + passwd
				+ ", role=" + role + "]";
	}
	
}
