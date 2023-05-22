package com.librarymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.librarymanagement.entity.Borrower;

public interface BorrowerRepository extends JpaRepository<Borrower, Long> {

}
