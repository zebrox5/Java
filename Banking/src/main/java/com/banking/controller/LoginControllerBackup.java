//package com.banking.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.banking.model.Customer;
//import com.banking.service.AuthService;
//
//@Controller
//public class LoginControllerBackup {
//	
////	ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
////	
////	AuthService service = (AuthService) ctx.getBean("authServiceBean");
//	AuthService service = new AuthService();
//	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String showLoginPage1() {
//		return "login";//this sends the request to the login page
//	}
//	
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public String showLoginPage() {
//		return "login";//this sends the request to the login page
//	}
//	
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public ModelAndView performLogin(@RequestParam("phone") String phone, @RequestParam("password") String password, Model model) {
//		boolean authenticate = service.authenticate(phone, password);
//		if(!authenticate) {
//			// customer not present
//			model.addAttribute("msg", "User not present. Register first...");
//			return new ModelAndView("login");
//			
//		}
//		return new ModelAndView("home");//this sends the request to the login page
//	}
//	
//	@RequestMapping(value = "/register", method = RequestMethod.GET)
//	public String showRegister() {
//		return "register";//this sends the request to the login page
//	}
//	
//	@RequestMapping(value = "/register", method = RequestMethod.POST)
//	public ModelAndView performRegistration(@RequestParam("custname") String custName,@RequestParam("phone") String phone, @RequestParam("password") String password,
//			@RequestParam("confirmPassword") String confirmPassword, Model model) {
//		
//		// Step 1 - To check both the password matches
//		if (!password.equals(confirmPassword)) {
//			model.addAttribute("msg", "Password didn't matched");
//			return new ModelAndView("register");
//		}
//
//		// Step 2 - Check whether the customer is present in repository or not
//		Customer customer = service.findCustomer(phone);
//		if (customer != null) {
//			//i.e. user already present 
//			model.addAttribute("error_msg", "User already present");
//			return new ModelAndView("register");
//		}
//		
//		// if the code get here this means the customer is null
//		customer = new Customer(custName, phone, password);
//		boolean result = service.registerCustomer(customer);
//		
//		if(!result) {
//			model.addAttribute("error_msg", "Something went wrong. Try Again");
//			return new ModelAndView("register");
//		}
//				
//		return new ModelAndView("login");
//	}
//
//}
