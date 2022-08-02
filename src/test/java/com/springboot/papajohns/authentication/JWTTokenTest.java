package com.springboot.papajohns.authentication;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class JWTTokenTest {

    @DisplayName("1, JWT 토큰이 잘 만들어 진다.")
    @Test
    void test() throws InterruptedException {
        Algorithm AL = Algorithm.HMAC256("hello");

        String token = JWT.create()
                .withSubject("jaean")
                .withClaim("exp", Instant.now().getEpochSecond() + 1)
                .withArrayClaim("role", new String[]{"ROLE_ADMIN", "ROLE_USER"})
                .sign(AL);

        System.out.println(token);

        DecodedJWT decodeJWT = JWT.decode(token);
        System.out.println("decode : " + decodeJWT);

        DecodedJWT verified = JWT.require(AL).build().verify(token);
        System.out.println("verified : " + verified);

        System.out.println("2초 대기");
        Thread.sleep(2000);

        assertThrows(TokenExpiredException.class, () -> {
            DecodedJWT decodeExpiredToken = JWT.require(AL).build().verify(token);
            System.out.println("expired : " + decodeExpiredToken);
        });
    }
}
