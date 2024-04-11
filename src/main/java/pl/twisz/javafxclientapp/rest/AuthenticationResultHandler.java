package pl.twisz.javafxclientapp.rest;

import pl.twisz.javafxclientapp.dto.OperatorAuthenticationResultDto;

@FunctionalInterface
public interface AuthenticationResultHandler {
    void handle(OperatorAuthenticationResultDto operatorAuthenticationResultDto);
}
