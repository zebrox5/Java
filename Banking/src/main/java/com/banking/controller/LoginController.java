package com.banking.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.banking.model.Customer;
import com.banking.service.AuthService;

@Controller
@SessionAttributes("custId-session")
public class LoginController {
	
//	ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
//	
//	AuthService service = (AuthService) ctx.getBean("authServiceBean");
	AuthService service = new AuthService();
	private static List<Integer> revokedTokens=new ArrayList<>();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView showLoginPage1(HttpSession session) {
		
		if (session != null && !revokedTokens.contains(session.getAttribute("custId-session"))) {
				return new ModelAndView("home");
		}
		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage() {
		return "login";//this sends the request to the login page
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView performLogin(HttpSession session, @RequestParam("phone") String phone, @RequestParam("password") String password, Model model) {
		boolean authenticate = service.authenticate(phone, password);
		if(!authenticate) {
			// customer not present
			model.addAttribute("msg", "User not present. Register first...");
			return new ModelAndView("login");
			
		}
		//check if the id present in revokedList , if present then remove it
		Customer customer = service.findCustomer(phone);
		int index = revokedTokens.indexOf(customer.getCustId());
		
		//if index = -1 then the token doesn't exist
		if(index != -1) {
			//otherwise custId exist
			revokedTokens.remove(index);
		}
		model.addAttribute("custId-session", customer.getCustId());

		return new ModelAndView("redirect:home");//this sends the request to the login page
	}
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView showHome() {
		return new ModelAndView("home");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegister() {
		return "register";//this sends the request to the login page
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView performRegistration(@RequestParam("custname") String custName,@RequestParam("phone") String phone, @RequestParam("password") String password,
			@RequestParam("confirmPassword") String confirmPassword, Model model) {
		
		// Step 1 - To check both the password matches
		if (!password.equals(confirmPassword)) {
			model.addAttribute("msg", "Password didn't matched");
			return new ModelAndView("register");
		}

		// Step 2 - Check whether the customer is present in repository or not
		Customer customer = service.findCustomer(phone);
		if (customer != null) {
			//i.e. user already present 
			model.addAttribute("error_msg", "User already present");
			return new ModelAndView("register");
		}
		
		// if the code get here this means the customer is null
		customer = new Customer(custName, phone, password);
		boolean result = service.registerCustomer(customer);
		
		if(!result) {
			model.addAttribute("error_msg", "Something went wrong. Try Again");
			return new ModelAndView("register");
		}
				
		return new ModelAndView("login");
	}
	

	
	@RequestMapping(path = "/logout", method = RequestMethod.POST)
	public ModelAndView getLogout(HttpSession session) throws Exception {
		if (session != null) {
			if(session.getAttribute("custId-session") != null) {
				revokedTokens.add((Integer) session.getAttribute("custId-session"));
				session.removeAttribute("custId-session");
				session.invalidate();
			}
			return new ModelAndView("login");
		}
		
		return new ModelAndView("login");
	}
	
	

}
