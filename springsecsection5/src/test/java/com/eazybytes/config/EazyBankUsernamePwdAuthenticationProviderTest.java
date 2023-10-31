package com.eazybytes.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
@ExtendWith(MockitoExtension.class)
class EazyBankUsernamePwdAuthenticationProviderTest {

    @InjectMocks
    private  EazyBankUsernamePwdAuthenticationProvider eazyBankUsernamePwdAuthenticationProvider;

    @Test
    void authenticate() {
        //Setup

        //Execution

        //Assert

    }

    @Test
    void supports() {
        //Setup
        boolean expected = true;
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken("abc","abc", Arrays.asList(new SimpleGrantedAuthority("ROLE_abc")));
        //Execution
        Boolean result = eazyBankUsernamePwdAuthenticationProvider.supports(usernamePasswordAuthenticationToken.getClass());
        //Assert
        assertEquals(expected,result);
    }
}