package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Books {
	private Integer id;
	private String name, author, subject;
	private float price;
	private Long isbn;
	private List<Copies> copies = new ArrayList<Copies>();

	public Books() {
		// TODO Auto-generated constructor stub
		System.out.println("Books()");
	}

	public Books(String name, String author, String subject, float price, Long isbn) {
		super();
		this.name = name;
		this.author = author;
		this.subject = subject;
		this.price = price;
		this.isbn = isbn;
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
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Column(length = 30)
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Long getIsbn() {
		return isbn;
	}

	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}
	
	@OneToMany(mappedBy = "bookid", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Copies> getCopies() {
		return copies;
	}

	public void setCopies(List<Copies> copies) {
		this.copies = copies;
	}
	
	public void addCopies(Copies c) {
		copies.add(c);
		c.setBookid(this);
	}

	public void removeCopies(Copies c) {
		copies.remove(c);
		c.setBookid(null);
	}

	@Override
	public String toString() {
		return "Books [id=" + id + ", name=" + name + ", author=" + author + ", subject=" + subject + ", price=" + price
				+ ", isbn=" + isbn + "]";
	}
}
