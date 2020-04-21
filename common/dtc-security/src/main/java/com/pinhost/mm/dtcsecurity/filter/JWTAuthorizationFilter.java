package com.pinhost.mm.dtcsecurity.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pinhost.mm.dtcsecurity.auth.SimpleGrantedAuthorityMixin;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        String header = request.getHeader("Authorization");

        logger.info("Die anfrage ist bis hier angekommen.");

        if (!requiresAuthentication(header)) {
            chain.doFilter(request, response);
            return;
        }

        boolean validTocken;
        Claims tocken = null;
        try {
            tocken = Jwts.parser().setSigningKey("Code.Security.Test".getBytes())
                    .parseClaimsJws(header.replace("Bearer ", "")).getBody();
            validTocken = true;
        } catch (JwtException | IllegalArgumentException e) {
            validTocken = false;
        }

        UsernamePasswordAuthenticationToken authentication = null;

        if (validTocken) {
            String username = tocken.getSubject();
            Object roles = tocken.get("authorities");

            Collection<? extends GrantedAuthority> authorities = Arrays
                    .asList(new ObjectMapper().addMixIn(SimpleGrantedAuthority.class, SimpleGrantedAuthorityMixin.class)
                            .readValue(roles.toString().getBytes(), SimpleGrantedAuthority[].class));
            authentication = new UsernamePasswordAuthenticationToken(username, null, authorities);
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
    }

    protected boolean requiresAuthentication(String header) {

        if (header == null || !header.startsWith("Bearer ")) {
            return false;
        }
        return true;
    }
}
