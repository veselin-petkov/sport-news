package com.example.sportnews.util;

import com.example.sportnews.core.MyUserSec;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtUtil {

    private final String SECRET_KEY="secret";
    public String extractUsername(String token){
        return extractClaim(token, Claims:: getSubject);
    }
    public Date extractExpiration(String token){
        return extractClaim(token,Claims :: getExpiration);
    }
    public<T>T extractClaim(String token, Function<Claims,T> claimsResolver){
        final Claims claims=extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private Claims extractAllClaims(String token){
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }
    private Boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }
    public String generateToken(MyUserSec myUserSec){
        Map<String,Object> claims=new HashMap<>();
        claims.put("id",myUserSec.getId());
        claims.put("role",myUserSec.getRole());
//        if (myUserSec.getRole()==2) {
//            claims.put("role_name", "ADMIN");
//        }else claims.put("role_name", "USER");
        return createToken(claims,myUserSec.getUsername());
    }
    private String createToken(Map<String,Object> claims, String subject){
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*60*10))
                .signWith(SignatureAlgorithm.HS256,SECRET_KEY).compact();
    }
    public Boolean validateToken(String token,UserDetails userDetails){
        final String username=extractUsername(token);
        return(username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
