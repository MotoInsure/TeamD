package com.ibm.motoInsure.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.motoInsure.EncodeDecode.Encryption;
import com.ibm.motoInsure.Exception.InvalidUserException;
import com.ibm.motoInsure.bean.Login;
import com.ibm.motoInsure.entity.Policy;
import com.ibm.motoInsure.entity.User;
import com.ibm.motoInsure.service.UserService;
/**
 *<p>This controller class maps the view of methods available to user wit data</p> 
 * @author Jai Baheti
 * @since 18-04-2021
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired 
	private UserService us;
	
	@GetMapping(value="/getUser/{name}", produces="application/json")
	public User getUser(@PathVariable String name) {
		return us.getUser(name);
	}
	/**
	 * 
	 * @param user
	 * @return confirmation of user addition
	 */
	@PostMapping(value="/addUser",consumes="application/json")
	public String addUser(@RequestBody User user) {		
		us.addUser(user);
		return "User added.";
	}
	/**
	 * 
	 * @param uname
	 * @return new password
	 */
	@GetMapping(value="/forgotPwd/{email}", produces="application/json")	
	public User getPassword(@PathVariable String email) throws InvalidUserException {
		Encryption encrypter = Encryption.getEncrypter();		
		User u1 = us.getUserByEmail(email);
		System.out.println(u1);
		User u = us.forgotPassword(u1.getEmail());
		u.setPassword(encrypter.DecodePassword(u.getPassword()));
		return u;
	}
	/**
	 * 
	 * @param login
	 * @param session
	 * @return response of authentication
	 */
	@GetMapping(value="/auth", produces="application/json")
	public ResponseEntity<?> authentication(@RequestParam("email") String email, @RequestParam("password") String password , HttpSession session) {
		Login login = new Login(email, password);
		User u = us.validate(login);
		if(u != null) {	
			session.setAttribute("USER", u); 
			return new ResponseEntity<User>(u, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Invalid username or password.",HttpStatus.NOT_FOUND);
		}		 		
	}
	/**
	 * 
	 * @param session
	 * @return confirmation of logout
	 */
	
	@GetMapping(value="/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "Logged Out.";
	}
	/**
	 * 
	 * @param userId
	 * @param policyId
	 * @param session
	 * @return response of addition of policy to user
	 */
	@PostMapping(value="/addPolicyToUser/{userId}/{policyId}")
	public ResponseEntity<?> addPolicyToUser(@PathVariable int userId,@PathVariable int policyId, HttpSession session) 
			throws InvalidUserException {
		//if(session.getAttribute("USER")!=null){
			return new ResponseEntity<Integer>(us.addPolicyToUser(userId, policyId), HttpStatus.OK);
		//}
//		else
//			return new ResponseEntity<String>("Sorry! You're not logged in",HttpStatus.NOT_FOUND);		
	}
	
	/**
	 * 
	 * @param userId
	 * @param vehicleId
	 * @param session
	 * @return response of userVehicle addition 
	 */
	@PostMapping(value="/addVehicle/{userId}/{vehicleId}", consumes="application/json")
	public ResponseEntity<?> addUserVehicle(@PathVariable int userId,@PathVariable String vehicleId,HttpSession session) throws InvalidUserException {
	//	if(session.getAttribute("USER")!=null){
			return new ResponseEntity<Integer>(us.addUserVehicle(userId,vehicleId), HttpStatus.OK);
	//	}
	//	else
		//	return new ResponseEntity<String>("Sorry! You're not logged in",HttpStatus.NOT_FOUND);
	}
}
