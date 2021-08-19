package www.commerce.controllers.api;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import www.commerce.configure.security.JwtTokenUtil;
import www.commerce.constants.Roles;
import www.commerce.dto.UserDTO;
import www.commerce.entities.Role;
import www.commerce.entities.User;
import www.commerce.repositories.RoleRepository;
import www.commerce.repositories.UserRepository;
import www.commerce.requests.AuthRequest;
import www.commerce.requests.JwtRequest;
import www.commerce.requests.RegisterRequest;
import www.commerce.response.JwtResponse;
import www.commerce.response.MessageResponse;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Tag(name = "Authentication")
@RestController
@RequestMapping(path = "api/public")
@RequiredArgsConstructor
public class AuthApi {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder encoder;

    @PostMapping("login")
    public ResponseEntity<UserDTO> login(@RequestBody @Valid AuthRequest request) {
        try {
            Authentication authenticate = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()));

            User user = (User) authenticate.getPrincipal();
            www.commerce.entities.User dbUser = userRepository.findByUsername(user.getUsername());
            UserDTO userView = new UserDTO();
            userView.setUsername(user.getUsername());
            return ResponseEntity.ok()
                    .header(HttpHeaders.AUTHORIZATION, jwtTokenUtil.generateAccessToken(dbUser))
                    .body(userView);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }


    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception
    {
        authenticationRequest.getPassword();
        final www.commerce.entities.User userDetails =
                userRepository.findByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateAccessToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    @RequestMapping(value="/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registerUser( @RequestBody RegisterRequest registerRequest) {


        if (userRepository.existsByUsername(registerRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

//        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
//            return ResponseEntity
//                    .badRequest()
//                    .body(new MessageResponse("Error: Email is already in use!"));
//        }

        // Create new user's account

        User user = new User(registerRequest.getUsername(), encoder.encode(registerRequest.getPassword()));
                //registerRequest.getEmail(),


        //<Role> strRoles = registerRequest.getRole();
        List<Role> roles = new ArrayList<Role>();

       //if (strRoles == null) {
        try{
            Role userRole = roleRepository.findByName(Roles.User);
            roles.add(userRole);
        }
        catch (Exception ex){
            return ResponseEntity
                    .badRequest()
                    .body(new RuntimeException("Error: Role is not found."));
        }

       // } else {
//            strRoles.forEach(role -> {
//                switch (role) {
//                    case Roles.Admin:
//                        Role adminRole = roleRepository.findByName(Roles.Admin)
//                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//                        roles.add(adminRole);
//                        break;
//                    default:
//                        Role userRole = roleRepository.findByName(Roles.User)
//                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//                        roles.add(userRole);
//                }
//            });
        //}

        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

}