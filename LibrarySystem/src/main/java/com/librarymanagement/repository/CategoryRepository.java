package com.librarymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.librarymanagement.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
