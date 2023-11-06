package fact.it.apigateway.service;

import fact.it.apigateway.controller.CsrfTokenController;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GatewayService {
    private final CsrfTokenController csrfTokenController;
}
