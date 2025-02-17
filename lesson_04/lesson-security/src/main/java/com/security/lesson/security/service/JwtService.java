package com.security.lesson.security.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
public class JwtService {
  private final Algorithm algorithm;

  public JwtService(@Value("${api.secret}") String secret) {
    this.algorithm = Algorithm.HMAC256(secret);
  }

  public String createToken(String username) {
    Instant expiredAt = Instant.now().plus(3, ChronoUnit.DAYS);

    return JWT.create()
        .withSubject(username)
        .withExpiresAt(expiredAt)
        .sign(algorithm);
  }

  public String verify(String token) {
    return JWT.require(algorithm)
        .build()
        .verify(token)
        .getSubject();
  }
}
