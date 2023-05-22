package com.librarymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.librarymanagement.entity.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

}
