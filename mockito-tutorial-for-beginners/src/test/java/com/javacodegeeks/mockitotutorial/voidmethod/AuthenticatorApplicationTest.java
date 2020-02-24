package com.javacodegeeks.mockitotutorial.voidmethod;

import static org.mockito.Mockito.doThrow;

import org.junit.Test;
import org.mockito.Mockito;

import com.javacodegeeks.mockitotutorial.voidmethod.AuthenticatorApplication;
import com.javacodegeeks.mockitotutorial.voidmethod.AuthenticatorInterface;
import com.javacodegeeks.mockitotutorial.voidmethod.NotAuthenticatedException;

public class AuthenticatorApplicationTest {

    @Test(expected = NotAuthenticatedException.class)
    public void testAuthenticate() throws NotAuthenticatedException {
        String username = "JavaCodeGeeks";
        String password = "wrong password";

        AuthenticatorInterface authenticatorMock = Mockito.mock(AuthenticatorInterface.class);
        AuthenticatorApplication authenticator = new AuthenticatorApplication(authenticatorMock);
        
        doThrow(new NotAuthenticatedException()).when(authenticatorMock).authenticateUser(username, password);
        
        authenticator.authenticate(username, password);
    }
}
