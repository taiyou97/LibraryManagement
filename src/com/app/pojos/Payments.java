package com.app.pojos;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.*;

@Entity
public class Payments {
	private Integer id;
	private float amount;
	private LocalTime transaction_time;
	private LocalDate nextpayment_duedate;
	private PaymentsType type;
	private Users userId;
	
	public Payments() {
		// TODO Auto-generated constructor stub
		System.out.println("Payments()");
	}
	
	public Payments(float amount, LocalTime transaction_time, LocalDate nextpayment_duedate, PaymentsType type) {
		super();
		this.amount = amount;
		this.transaction_time = transaction_time;
		this.nextpayment_duedate = nextpayment_duedate;
		this.type = type;
	}

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public LocalTime getTransaction_time() {
		return transaction_time;
	}

	public void setTransaction_time(LocalTime transaction_time) {
		this.transaction_time = transaction_time;
	}

	public LocalDate getNextpayment_duedate() {
		return nextpayment_duedate;
	}

	public void setNextpayment_duedate(LocalDate nextpayment_duedate) {
		this.nextpayment_duedate = nextpayment_duedate;
	}

	@Enumerated(EnumType.STRING)
	public PaymentsType getType() {
		return type;
	}

	public void setType(PaymentsType type) {
		this.type = type;
	}

	@ManyToOne
	@JoinColumn(name = "user_Id")
	public Users getUserId() {
		return userId;
	}

	public void setUserId(Users userId) {
		this.userId = userId;
	}

	
	@Override
	public String toString() {
		return "Payments [id=" + id + ", amount=" + amount + ", transaction_time=" + transaction_time
				+ ", nextpayment_duedate=" + nextpayment_duedate + ", type=" + type + "]";
	}

}
