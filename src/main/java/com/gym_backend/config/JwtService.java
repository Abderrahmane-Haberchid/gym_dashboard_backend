package com.gym_backend.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class JwtService {

    public String extractEmail(String token){
        return extractClaim(token, Claims::getSubject);
    }
    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(), userDetails);
    }
    public String generateToken(Map<String, Object> extraClaim, UserDetails userDetails){
        return Jwts.builder()
                .setClaims(extraClaim)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getSigninKey(), SignatureAlgorithm.ES256)
                .compact();
    }
    public boolean isTokenValid(String token, UserDetails userDetails){
        final String userName = userDetails.getUsername();
        return (userName.equals(extractEmail(token)) && !isTokenExpired(token));
    }
    public boolean isTokenExpired(String token){
        if (extractExpiration(token).before(new Date())) {
            return true;
        }
        else return false;
    }
    private <T> T extractClaim(String token, Function<Claims, T> claimsResolvers){
        Claims claims = extractAllClaims(token);
        return claimsResolvers.apply(claims);
    }
    private Claims extractAllClaims(String token){
        return Jwts.parserBuilder().setSigningKey(getSigninKey()).build().parseClaimsJws(token)
                .getBody();
    }
    private Date extractExpiration(String token){
        return extractClaim(token, Claims::getExpiration);
    }
    private Key getSigninKey(){
        String SECRET_KEY = "413F4428472B4B6250655368566D5970337336763979244226452948404D6351";
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
