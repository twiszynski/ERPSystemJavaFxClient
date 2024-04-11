package pl.twisz.javafxclientapp.rest;

import pl.twisz.javafxclientapp.dto.OperatorCredentialsDto;

public interface Authenticator {

    void authenticate(OperatorCredentialsDto operatorCredentialsDto, AuthenticationResultHandler authenticationResultHandler);
}
