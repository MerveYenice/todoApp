package org.yenice.todolist;

import io.jsonwebtoken.*;

import java.util.Date;

public class JwtProvider {

    public String getTokenForUser(String email, long millisToLive) {
        return Jwts.builder()
                .setId(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + millisToLive))
                .compact();
    }

    public String getEmailFromToken(String token) {
        return Jwts.parser().setSigningKey("secret key").parseClaimsJws(token).getBody().getId();
    }

}
