package com.spring.test.Controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.test.Jwt.JwtUtils;
import com.spring.test.Model.Roles;
import com.spring.test.Model.Users;
import com.spring.test.Repo.RoleRepo;
import com.spring.test.Repo.UserRepo;
import com.spring.test.Request.LoginRequest;
import com.spring.test.Request.SignupRequest;
import com.spring.test.Response.AuthenticationResponse;
import com.spring.test.Security.CustomUserDetails;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private JwtUtils jwtUtil;

	@Autowired
	private RoleRepo roleRepo;

	@Autowired
	private PasswordEncoder passwordEncoder; 
	
	
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestBody SignupRequest signUpRequest) {

		if (userRepo.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity<>("Email already exist", HttpStatus.BAD_REQUEST);
		}
		
		if(!signUpRequest.getPassword().equals(signUpRequest.getConfirmpassword())){
		  return new ResponseEntity<>("Password does not match !!",HttpStatus.BAD_REQUEST);
		}
		
		Users users = new Users();
		users.setUsername(signUpRequest.getUsername());
		users.setEmail(signUpRequest.getEmail());
		users.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
	
		Set<Roles> roles = new HashSet<>();
		Roles r = roleRepo.findById(signUpRequest.getRoleId())
				.orElseThrow(() -> new RuntimeException("Role Not Found"));
		roles.add(r);

		users.setRoles(roles);

		return new ResponseEntity<>(userRepo.save(users), HttpStatus.CREATED);
	}
	
	
	
	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtil.generateJwtToken(authentication);

		CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());
		
		AuthenticationResponse response = new  AuthenticationResponse();
		response.setUsername(userDetails.getUsername());
		response.setId(userDetails.getId());
		response.setRoles(roles);
		response.setToken(jwt);

		return new  ResponseEntity<>(response,HttpStatus.OK);
	}
}
