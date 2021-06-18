package com.banking.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.banking.model.Account;
import com.banking.model.Transactions;
import com.banking.service.TransactionService;

@Controller
@SessionAttributes("custId-session")
public class TransactionController {

//	
	TransactionService service = new TransactionService();
	//private final int custId = 4;

	@RequestMapping(value = "/deposit", method = RequestMethod.GET)
	public String showDepositPage(HttpSession session) {
		int custId = (Integer) session.getAttribute("custId-session");
		System.out.println("User id is  => " + custId);
		return "deposit";// this sends the request to the login page
	}

	@RequestMapping(value = "/withdraw", method = RequestMethod.GET)
	public String showWithdrawPage() {
		return "withdraw";// this sends the request to the login page
	}

	@RequestMapping(value = "/deposit", method = RequestMethod.POST)
	public ModelAndView performDeposit(HttpSession session, @RequestParam("deposit") double depositAmount, Model model) {
		int custId = (Integer) session.getAttribute("custId-session");
		// 1. check if the account exists or not
		boolean isAccountExist = service.isAccountExists(custId);
		if (!isAccountExist) {
			// create an account
			Account account = new Account();
			account.setCustId(custId);
			boolean isAccountCreted = service.createAccount(account);
			
			if(!isAccountCreted) {
				model.addAttribute("msg", "Something went wrong....");
				return new ModelAndView("deposit");
			}
//			if (isAccountCreted) {
//
//				model.addAttribute("msg", "Add amount to the account....");
//				return new ModelAndView("deposit");
//			} else {
//				model.addAttribute("msg", "Something went wrong....");
//				return new ModelAndView("deposit");
//			}
		}
		// 2. get the account balance and add it

		double newBalance = service.getAccountBalance(custId) + depositAmount;
		// create account and update in db

		Account account = new Account();
		account.setCustId(custId);
		account.setBalance(newBalance);

		boolean isUpdated = service.updateAccountBalance(account);
		if (!isUpdated) {
			model.addAttribute("msg", "Something went wrong with deposit....");
			return new ModelAndView("deposit");
		}
		
		boolean isTransactionUpdated = service.updateTransactions(custId, new Date(System.currentTimeMillis()),
				depositAmount, newBalance, "deposit");

		model.addAttribute("msg", "Successfully deposited and transaction update " 
				+ (isTransactionUpdated ? "successfully" : "un-successfully"));
		return new ModelAndView("deposit");// this sends the request to the login page
	}

	@RequestMapping(value = "/withdraw", method = RequestMethod.POST)
	public ModelAndView performWithdrawl(HttpSession session, @RequestParam("withdraw") double withdrawAmount, Model model) {
		int custId = (Integer) session.getAttribute("custId-session");
		// 1. check if the account exists or not
		boolean isAccountExist = service.isAccountExists(custId);
		if (!isAccountExist) {
			// create an account
			Account account = new Account();
			account.setCustId(custId);
			boolean isAccountCreted = service.createAccount(account);
			if (isAccountCreted) {

				model.addAttribute("msg", "Add amount to the account....");
				return new ModelAndView("deposit");
			} else {
				model.addAttribute("msg", "Something went wrong....");
				return new ModelAndView("deposit");
			}
		}
		// 2. get the account balance and check whether the requested amount is smaller
		// than the available amount
		double accountBalance = service.getAccountBalance(custId);
		if (withdrawAmount > accountBalance) {
			model.addAttribute("msg", "Amount requested is more than the available....");
			return new ModelAndView("withdraw");
		}

		double newBalance = accountBalance - withdrawAmount;
		// create account and update in db

		Account account = new Account();
		account.setCustId(custId);
		account.setBalance(newBalance);

		boolean isUpdated = service.updateAccountBalance(account);
		if (!isUpdated) {
			model.addAttribute("msg", "Something went wrong with deposit....");
			return new ModelAndView("deposit");
		}
		boolean isTransactionUpdated = service.updateTransactions(custId, new Date(System.currentTimeMillis()),
				withdrawAmount, newBalance, "withdraw");

		model.addAttribute("msg", "Successfully Withdrawn and transaction update "
				+ (isTransactionUpdated ? "successfully" : "un-successfully"));
		return new ModelAndView("withdraw");// this sends the request to the login page
	}
	
	@RequestMapping(value = "/transactionhistory", method = RequestMethod.GET)
	public ModelAndView showTransactionHistory(HttpSession session, Model model) throws JsonGenerationException, JsonMappingException, IOException  {
		
		int custId = (Integer) session.getAttribute("custId-session");
		List<Transactions> allTransactions = service.getAllTransactions(custId);
		
		if(allTransactions == null || allTransactions.isEmpty()) {
			model.addAttribute("msg", "No transactions available");
			return new ModelAndView("transactionhistory");
		}
        ObjectMapper mapper = new ObjectMapper();
		
		model.addAttribute("customerList", mapper.writeValueAsString(allTransactions));
		return new ModelAndView("transactionhistory");
		
		
	}

}
