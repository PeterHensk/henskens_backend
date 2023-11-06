package fact.it.apigateway.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/gateway")
@RequiredArgsConstructor
public class CsrfTokenController {
//    @GetMapping("/csrf")
//    public String getCsrfToken(HttpServletRequest request) {
//        CsrfToken token = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
//        return token.getToken();
//    }
}
