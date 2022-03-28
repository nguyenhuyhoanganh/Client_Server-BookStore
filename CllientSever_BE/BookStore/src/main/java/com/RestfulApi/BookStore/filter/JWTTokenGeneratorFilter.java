package com.RestfulApi.BookStore.filter;

/*import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.RestfulApi.BookStore.constant.SecurityConstants;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;*/

public class JWTTokenGeneratorFilter /* extends OncePerRequestFilter */ {
	/*
	 * // thực thi 1 lần duy nhất cho mỗi request
	 * 
	 * @Override protected void doFilterInternal(HttpServletRequest request,
	 * HttpServletResponse response, FilterChain chain) throws IOException,
	 * ServletException { Authentication authentication =
	 * SecurityContextHolder.getContext().getAuthentication(); if (null !=
	 * authentication) { SecretKey key =
	 * Keys.hmacShaKeyFor(SecurityConstants.JWT_KEY.getBytes(StandardCharsets.UTF_8)
	 * ); String jwt = Jwts.builder() // header .setIssuer("hoang anh") // người
	 * phát hành .setSubject("JWT Token") // chủ đề // payload .claim("username",
	 * authentication.getName()) .claim("authorities",
	 * populateAuthorities(authentication.getAuthorities())).setIssuedAt(new Date())
	 * .setExpiration(new Date((new Date()).getTime() + 3000000)) // signature
	 * .signWith(key).compact(); response.setHeader(SecurityConstants.JWT_HEADER,
	 * jwt); } chain.doFilter(request, response); }
	 * 
	 * @Override protected boolean shouldNotFilter(HttpServletRequest request) {
	 * return !request.getServletPath().equals("/login"); } // chỉ nên được thực thi
	 * khi login // đảm bảo chỉ generate filter khi người dùng login
	 * 
	 * private String populateAuthorities(Collection<? extends GrantedAuthority>
	 * collection) { Set<String> authoritiesSet = new HashSet<>(); for
	 * (GrantedAuthority authority : collection) {
	 * authoritiesSet.add(authority.getAuthority()); } return String.join(",",
	 * authoritiesSet); }
	 */

}