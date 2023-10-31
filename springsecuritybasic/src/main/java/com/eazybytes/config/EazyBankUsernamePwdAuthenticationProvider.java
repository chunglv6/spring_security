package com.eazybytes.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//
//public class EazyBankUsernamePwdAuthenticationProvider implements AuthenticationProvider {
//
//    @Autowired
//    private InMemoryUserDetailsManager inMemoryUserDetailsManager;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Override
//    public Authentication authenticate(Authentication authentication) {
//        String username = authentication.getName();
//        String pwd = authentication.getCredentials().toString();
//
//            if (passwordEncoder.matches(pwd, inMemoryUserDetailsManager.loadUserByUsername(username).getPassword())) {
//                List<GrantedAuthority> authorities = new ArrayList<>();
//                authorities.add((GrantedAuthority) inMemoryUserDetailsManager.loadUserByUsername(username).getAuthorities());
//                return new UsernamePasswordAuthenticationToken(username, pwd, authorities);
//            } else {
//                throw new BadCredentialsException("Invalid password!");
//            }
//
//    }
//
//    @Override
//    public boolean supports(Class<?> authenticationType) {
//        return authenticationType.equals(UsernamePasswordAuthenticationToken.class);
//    }
//}
