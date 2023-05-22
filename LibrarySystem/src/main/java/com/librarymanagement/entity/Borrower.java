package com.librarymanagement.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "borrowers")
public class Borrower {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "borrower_sequence")
    @SequenceGenerator(name = "borrower_sequence", sequenceName = "borrower_sequence", allocationSize = 1)
    private Long id;


	@Column(name = "name", length = 100, nullable = false, unique = true)
	private String name;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "borrowers")
	private Set<Book> books = new HashSet<Book>();

	public Borrower(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public Borrower() {
		super();
	}

}
