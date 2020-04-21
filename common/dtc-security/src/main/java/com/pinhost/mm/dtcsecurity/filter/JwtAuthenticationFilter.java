package com.pinhost.mm.dtcsecurity.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pinhost.mm.dtcdatabase.model.UserModel;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@CrossOrigin(origins = {"http://localhost:4200"})
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/login", "POST"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

       String username = obtainUsername(request);
        String password = obtainPassword(request);
        if (username == null) {
            username = "";
        }
        if (password == null) {
            password = "";
        }
        if (username != null && password != null) {
            logger.info("Username von Request: ".concat(username));
            logger.info("Password von Request: ".concat(password));
        }/*else{
            User user= null;
            try {
                user = new ObjectMapper().readValue(request.getInputStream(), User.class);
                username = user.getUsername();
                password = user.getPassword();

                logger.info("Username von Request InputStream (raw): ".concat(username));
                logger.info("Password von Request InputStream (raw): ".concat(password));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/

        username = username.trim();

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        Authentication test = authenticationManager.authenticate(authenticationToken);
        return test;

    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        String username = ((User) authResult.getPrincipal()).getUsername();

        Collection<? extends GrantedAuthority> roles = authResult.getAuthorities();

        Claims claims = Jwts.claims();
        claims.put("authorities", new ObjectMapper().writeValueAsString(roles));

        String token = Jwts.builder().setClaims(claims).setSubject(username)
                .signWith(SignatureAlgorithm.HS512, "Code.Security.Test".getBytes())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000L)).compact();

        response.addHeader("Authorization", "Bearer" + token);

        Map<String, Object> body = new HashMap<String, Object>();
        body.put("token", token);
        body.put("user", (User) authResult.getPrincipal());
        body.put("message", String.format("Hallo %s, Sie sind jetzt eingelogt.!", ((User) authResult.getPrincipal()).getUsername()));

        response.getWriter().write(new ObjectMapper().writeValueAsString(body));
        response.setStatus(200);
        response.setContentType("application/json");
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                              AuthenticationException failed) throws IOException, ServletException {

        Map<String, Object> body = new HashMap<String, Object>();
        body.put("message", "Error Autenticación: falsche username o password!");
        body.put("error", failed.getMessage());

        response.getWriter().write(new ObjectMapper().writeValueAsString(body));
        response.setStatus(401);
        response.setContentType("application/json");
    }
}
