package com.librarymanagement.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.librarymanagement.entity.Borrower;
import com.librarymanagement.exception.NotFoundException;
import com.librarymanagement.repository.BorrowerRepository;
import com.librarymanagement.service.BorrowerService;

@Service
public class BorrowerServiceImpl implements BorrowerService {

	final BorrowerRepository borrowerRepository;

	public BorrowerServiceImpl(BorrowerRepository borrowerRepository) {
		this.borrowerRepository = borrowerRepository;
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public List<Borrower> findAllBorrowers() {
		return borrowerRepository.findAll();
	}

	@Override
	public Borrower findBorrowerById(Long id) {
		return borrowerRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(String.format("Borrower4 not found  with ID %d", id)));
	}

	@Override
	public void createBorrower(Borrower borrower) {
		borrowerRepository.save(borrower);
	}

	@Override
	public void updateBorrower(Borrower borrower) {
		borrowerRepository.save(borrower);
	}

	@Override
	public void deleteBorrower(Long id) {
		var borrower = borrowerRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(String.format("Borrower not found  with ID %d", id)));

		borrowerRepository.deleteById(borrower.getId());
	}

}
