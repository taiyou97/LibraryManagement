package com.app.utility;

public class BookReport {
	private Integer id;
	private String name;
	private int Available;
	private boolean issued;
	private int count;

	public BookReport() {
		System.out.println("BookReport()");
	}

	public BookReport(Integer id, String name, int available, boolean issued, int count) {
		super();
		this.id = id;
		this.name = name;
		Available = available;
		this.issued = issued;
		this.count = count;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAvailable() {
		return Available;
	}

	public boolean isIssued() {
		return issued;
	}

	public int getCount() {
		return count;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAvailable(int available) {
		Available = available;
	}

	public void setIssued(boolean issued) {
		this.issued = issued;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "BookReport [id=" + id + ", name=" + name + ", Available=" + Available + ", issued=" + issued
				+ ", count=" + count + "]";
	}

}
