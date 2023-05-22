package com.librarymanagement.service;

import java.util.List;

import com.librarymanagement.entity.Borrower;

public interface BorrowerService {

	public List<Borrower> findAllBorrowers();

	public Borrower findBorrowerById(Long id);

	public void createBorrower(Borrower borrower);

	public void updateBorrower(Borrower borrower);

	public void deleteBorrower(Long id);

}
