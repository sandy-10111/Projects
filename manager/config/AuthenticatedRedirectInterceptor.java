package com.system.manager.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;

public class AuthenticatedRedirectInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String requestURI = request.getRequestURI();

        // Redirect logged-in users from /login to /welcome
        if (authentication != null && authentication.getPrincipal() != "anonymousUser" && authentication.isAuthenticated() && requestURI.equals("/login")) {
            response.sendRedirect("/welcome");
            return false;
        }

        // Allow unauthenticated requests to proceed
        return true;
    }

}