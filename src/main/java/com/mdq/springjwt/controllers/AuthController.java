package com.mdq.springjwt.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mdq.springjwt.models.ERole;
import com.mdq.springjwt.models.Role;
import com.mdq.springjwt.models.User;
import com.mdq.springjwt.payload.request.LoginRequest;
import com.mdq.springjwt.payload.request.SignupRequest;
import com.mdq.springjwt.payload.response.JwtResponse;
import com.mdq.springjwt.payload.response.MessageResponse;
import com.mdq.springjwt.repository.RoleRepository;
import com.mdq.springjwt.repository.UserRepository;
import com.mdq.springjwt.security.jwt.JwtUtils;
import com.mdq.springjwt.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
  private final AuthenticationManager authenticationManager;
  private final UserRepository userRepository;
  private final RoleRepository roleRepository;
  private final PasswordEncoder encoder;
  private final JwtUtils jwtUtils;

  @Autowired
  public AuthController(
          AuthenticationManager authenticationManager,
          UserRepository userRepository,
          RoleRepository roleRepository,
          PasswordEncoder encoder,
          JwtUtils jwtUtils) {
    this.authenticationManager = authenticationManager;
    this.userRepository = userRepository;
    this.roleRepository = roleRepository;
    this.encoder = encoder;
    this.jwtUtils = jwtUtils;
  }
  @PostMapping("/signin")
  public ResponseEntity<JwtResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);
    
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();    
    List<String> roles = userDetails.getAuthorities().stream()
        .map(item -> item.getAuthority())
        .collect(Collectors.toList());

    return ResponseEntity.ok(new JwtResponse(jwt, 
                         userDetails.getId(), 
                         userDetails.getUsername(), 
                         userDetails.getEmail(), 
                         roles));
  }
  private static final String ROLE_NOT_FOUND_ERROR = "Error: Role is not found.";
  @PostMapping("/signup")
  public ResponseEntity<MessageResponse> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
      boolean usernameExists = userRepository.existsByUsername(signUpRequest.getUsername());
      boolean emailExists = userRepository.existsByEmail(signUpRequest.getEmail());

      if (usernameExists || emailExists) {
        String errorMessage = usernameExists ? "Error: Username is already taken!" : "Error: Email is already in use!";
        return ResponseEntity.badRequest().body(new MessageResponse(errorMessage));
      }

    // Create new user's account
    User user = new User(signUpRequest.getUsername(), 
               signUpRequest.getEmail(),
               encoder.encode(signUpRequest.getPassword()));

    Set<String> strRoles = signUpRequest.getRole();
    Set<Role> roles = new HashSet<>();
    Role defaultRole = roleRepository.findByName(ERole.ROLE_USER)
            .orElseThrow(() -> new RuntimeException(ROLE_NOT_FOUND_ERROR));
    if (strRoles == null) {
      roles.add(defaultRole);
    } else {
      strRoles.forEach(role -> {
        Role currentRole;
        switch (role) {
        case "admin":
          currentRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                  .orElseThrow(() -> new RuntimeException(ROLE_NOT_FOUND_ERROR));
          break;
        case "mod":
          currentRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                  .orElseThrow(() -> new RuntimeException(ROLE_NOT_FOUND_ERROR));
          break;
        default:
          currentRole = defaultRole;
        }
        roles.add(currentRole);
      });
    }

    user.setRoles(roles);
    userRepository.save(user);

    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
  }
}
