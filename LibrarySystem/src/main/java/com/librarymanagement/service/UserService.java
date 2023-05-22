package com.librarymanagement.service;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

	String getUsername();

}