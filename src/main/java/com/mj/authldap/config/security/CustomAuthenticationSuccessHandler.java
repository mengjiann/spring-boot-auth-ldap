package com.mj.authldap.config.security;

import com.mj.authldap.domain.UserSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class CustomAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler
        implements AuthenticationSuccessHandler{

    private final static String DEFAULT_REDIRECT_URL_AFTER_LOGIN = "/index";

    public CustomAuthenticationSuccessHandler(){
        super();
        setUseReferer(true);
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {

        UserSession authUser = (UserSession) authentication.getPrincipal();

        log.info("Logged in username: {}", authUser.getUsername());

//        Allow user to be redirected to the request resource after authentication
        SavedRequest savedRequest = (SavedRequest) request.getSession().getAttribute("SPRING_SECURITY_SAVED_REQUEST");
        String redirectUrl = savedRequest == null ? DEFAULT_REDIRECT_URL_AFTER_LOGIN : savedRequest.getRedirectUrl();

        response.sendRedirect(redirectUrl);

    }
}
