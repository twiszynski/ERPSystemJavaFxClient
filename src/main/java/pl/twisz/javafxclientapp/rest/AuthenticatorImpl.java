package pl.twisz.javafxclientapp.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import pl.twisz.javafxclientapp.dto.OperatorAuthenticationResultDto;
import pl.twisz.javafxclientapp.dto.OperatorCredentialsDto;
import org.springframework.web.*;

public class AuthenticatorImpl implements Authenticator {

    private static final String AUTHENTICATION_URL = "http://localhost:8080/verify_operator_credentials";

    private final RestTemplate restTemplate;

    public AuthenticatorImpl() {
        restTemplate = new RestTemplate();
    }

    @Override
    public void authenticate(OperatorCredentialsDto operatorCredentialsDto, AuthenticationResultHandler authenticationResultHandler) {
        Runnable authenticationTask = () -> {
            processAuthentication(operatorCredentialsDto, authenticationResultHandler);
        };
        Thread authenticationThread = new Thread(authenticationTask);
        authenticationThread.setDaemon(true);
        authenticationThread.start();
    }

    private void processAuthentication(OperatorCredentialsDto operatorCredentialsDto, AuthenticationResultHandler authenticationResultHandler) {
//        ResponseEntity<OperatorAuthenticationResultDto> responseEntity = restTemplate
//                .postForEntity(AUTHENTICATION_URL, operatorCredentialsDto, OperatorAuthenticationResultDto.class);
        OperatorAuthenticationResultDto operatorDto = new OperatorAuthenticationResultDto();
        operatorDto.setAuthenticated(true);
        operatorDto.setFirstName("Tom");
        operatorDto.setLastName("Wis");
        operatorDto.setIdOperator(1L);
        authenticationResultHandler.handle(operatorDto);
    }
}
