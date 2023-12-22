package com.npci.loanActivity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.npci.loanActivity.entities.Customer;
import com.npci.loanActivity.entities.Loan;
import com.npci.loanActivity.serviceImpl.CustomerServiceImpl;
import com.npci.loanActivity.serviceImpl.LoanServiceImpl;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerServiceImpl service;
	
	@Autowired
	private LoanServiceImpl loanService;
	
	@PostMapping(path="/register",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registerCustomer(@RequestBody Customer customer){
		return ResponseEntity.status(201).body(service.registerUser(customer));
	}
	
	@GetMapping("/login")
	public String login(@RequestBody Customer customer , RedirectAttributes redirectAttributes) {
		String email=customer.getEmail();
		String password=customer.getPassword();
		Customer existCustomer=service.getCustomerOnEmail(email);
		if(existCustomer!=null) {
			if(existCustomer.getEmail()==email && existCustomer.getPassword()==password) {
				redirectAttributes.addFlashAttribute("applicationSuccess", true);
				return "redirect:/view-loans";
			}else {
				return "redirect:/successPage";
			}
		}
		return "redirect:/register";
	}
	
	@GetMapping("/view-loans")
    public ResponseEntity<Object> viewLoans(Model model) {
		
        List<Loan> loans = loanService.getAllLoans();
        return ResponseEntity.status(200).body(loans);
    }

    @PostMapping("/apply-for-loan/{loanType}")
    public String applyForLoan(@PathVariable String loanType,
            RedirectAttributes redirectAttributes ) {
        
        		 
        		Loan loan = loanService.applyForLoan(loanType);

        if (loan != null) {
            redirectAttributes.addFlashAttribute("applicationSuccess", true);
        } else {
            redirectAttributes.addFlashAttribute("applicationError", true);
        }

        return "redirect:/view-loans";
    }

    @GetMapping("/loan-status")
    public String viewLoanStatus(@RequestParam Long loanId, Model model) {
        Loan loan = loanService.getLoanStatus(loanId);
        model.addAttribute("loan", loan);
        return "loanStatus";
    }
	
	

}
