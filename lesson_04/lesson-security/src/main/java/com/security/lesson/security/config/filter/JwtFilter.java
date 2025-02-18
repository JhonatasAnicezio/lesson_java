package com.security.lesson.security.config.filter;

import com.security.lesson.security.model.entity.Person;
import com.security.lesson.security.service.JwtService;
import com.security.lesson.security.service.PersonService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Component
public class JwtFilter extends OncePerRequestFilter {
  private final JwtService jwtService;
  private final PersonService personService;

  @Autowired
  public JwtFilter(JwtService jwtService, PersonService personService) {
    this.jwtService = jwtService;
    this.personService = personService;
  }
  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    Optional<String> token = extractToken(request);

    if(token.isPresent()) {
      String username = jwtService.verify(token.get());

      UserDetails userDetails = personService.loadUserByUsername(username);

      UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
          new UsernamePasswordAuthenticationToken(userDetails.getUsername(), null, userDetails.getAuthorities());

      SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
    }

    filterChain.doFilter(request, response);

  }

  private Optional<String> extractToken(HttpServletRequest request) {
    Optional<String> authorization = Optional.ofNullable(request.getHeader("Authorization"));

    if(authorization.isEmpty()) {
      return Optional.empty();
    }

    return Optional.of(
        authorization.get().replace("Bearer", "")
    );
  }
}
