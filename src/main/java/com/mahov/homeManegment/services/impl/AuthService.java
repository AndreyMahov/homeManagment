package com.mahov.homeManegment.services.impl;


import com.mahov.homeManegment.config.jwt.JwtUtils;
import com.mahov.homeManegment.domain.enums.ERole;
import com.mahov.homeManegment.domain.models.Role;
import com.mahov.homeManegment.domain.models.User;
import com.mahov.homeManegment.domain.requestDto.authDto.LoginRequest;
import com.mahov.homeManegment.domain.requestDto.authDto.SignupRequest;
import com.mahov.homeManegment.domain.responseDto.JwtResponse;
import com.mahov.homeManegment.domain.responseDto.MessageResponse;
import com.mahov.homeManegment.jwt.JwtUserDetails;
import com.mahov.homeManegment.repositories.RoleRepository;
import com.mahov.homeManegment.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class AuthService {


    private final AuthenticationManager authenticationManager;


    private final UserService userService;


    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;


    private final JwtUtils jwtUtils;

    public AuthService(AuthenticationManager authenticationManager, UserService userService, RoleRepository roleRepository, PasswordEncoder passwordEncoder, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
    }

    public JwtResponse authUser(LoginRequest loginRequest){

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        JwtUserDetails userDetails = (JwtUserDetails) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                roles);
    }

    public ResponseEntity<?> registerUser(SignupRequest signupRequest) {

        if (userService.existsByLogin(signupRequest.getLogin())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is exist"));
        }

        User person = new User(signupRequest.getLogin(),
                passwordEncoder.encode(signupRequest.getPassword()));
        Set<Role> roles = new HashSet<>();

        Role userRole = roleRepository
                .findByName(ERole.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Error, Role USER is not found"));
        roles.add(userRole);

        person.setRoles(roles);
        userService.save(person);
        return ResponseEntity.ok(new MessageResponse("User CREATED"));
    }
}
