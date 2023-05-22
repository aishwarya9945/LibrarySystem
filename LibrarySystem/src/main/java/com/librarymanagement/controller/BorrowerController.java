package com.librarymanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.librarymanagement.entity.Borrower;
import com.librarymanagement.service.BorrowerService;


@Controller
public class BorrowerController {

	final BorrowerService borrowerService;

	public BorrowerController(BorrowerService borrowerService) {
		this.borrowerService = borrowerService;

	}

	@RequestMapping("/borrowers")
	public String findAllBorrowers(Model model) {

		model.addAttribute("borrowers", borrowerService.findAllBorrowers());
		return "list-borrowers";
	}

	@RequestMapping("/borrower/{id}")
	public String findBorrowerById(@PathVariable("id") Long id, Model model) {

		model.addAttribute("borrower", borrowerService.findBorrowerById(id));
		return "list-borrower";
	}

	@GetMapping("/addBorrower")
	public String showCreateForm(Borrower borrower) {
		return "add-borrower";
	}

	@RequestMapping("/add-borrower")
	public String createBorrower(Borrower borrower, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-borrower";
		}

		borrowerService.createBorrower(borrower);
		model.addAttribute("borrower", borrowerService.findAllBorrowers());
		return "redirect:/borrowers";
	}

	@GetMapping("/updateBorrower/{id}")
	public String showUpdateForm(@PathVariable("id") Long id, Model model) {

		model.addAttribute("borrower",borrowerService.findBorrowerById(id));
		return "update-borrower";
	}

	@RequestMapping("/update-borrower/{id}")
	public String updateBorrower(@PathVariable("id") Long id, Borrower borrower, BindingResult result, Model model) {
		if (result.hasErrors()) {
			borrower.setId(id);
			return "update-borrowers";
		}

		borrowerService.updateBorrower(borrower);
		model.addAttribute("borrower", borrowerService.findAllBorrowers());
		return "redirect:/borrowers";
	}

	@RequestMapping("/remove-borrower/{id}")
	public String deleteBorrower(@PathVariable("id") Long id, Model model) {
		borrowerService.deleteBorrower(id);

		model.addAttribute("borrower", borrowerService.findAllBorrowers());
		return "redirect:/borrowers";
	}

}
