package com.sistema.base.security;

import java.io.IOException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;

    public JwtAuthFilter(JwtUtil jwtUtil, UserDetailsService userDetailsService) {
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        String path = request.getServletPath();

        System.out.println(">>> PATH: " + path);
        System.out.println(">>> AUTH HEADER: " + request.getHeader("Authorization"));

        // 🔓 Endpoints públicos → NO validar JWT
        if (path.equals("/api/auth/login") ||
            path.equals("/api/auth/register") ||
            path.equals("/api/auth/verify") ||
            path.equals("/api/rol/todos")) { // permite mostrar roles
            filterChain.doFilter(request, response);
            return;
        }

        final String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            System.out.println(">>> NO JWT TOKEN - continuando sin autenticar");
            filterChain.doFilter(request, response);
            return;
        }

        String token = authHeader.substring(7);
        String userEmail;

        try {
            userEmail = jwtUtil.getEmailFromToken(token);
            System.out.println(">>> EMAIL EXTRAÍDO DEL TOKEN: " + userEmail);
        } catch (Exception e) {
            System.out.println(">>> ERROR AL PARSEAR TOKEN: " + e.getMessage());
            filterChain.doFilter(request, response);
            return;
        }

        if (userEmail != null &&
                SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails = userDetailsService.loadUserByUsername(userEmail);

            if (userDetails != null) {
                System.out.println(">>> USUARIO CARGADO: " + userDetails.getUsername());
                System.out.println(">>> AUTHORITIES: " + userDetails.getAuthorities());

                // ✅ Validar que el token sea válido
                if (jwtUtil.isTokenValid(token, userDetails)) {
                    System.out.println(">>> TOKEN VÁLIDO - autenticando usuario");

                    UsernamePasswordAuthenticationToken authToken =
                            new UsernamePasswordAuthenticationToken(
                                    userDetails,
                                    null,
                                    userDetails.getAuthorities());

                    authToken.setDetails(
                            new WebAuthenticationDetailsSource()
                                    .buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(authToken);
                } else {
                    System.out.println(">>> TOKEN INVÁLIDO O EXPIRADO");
                }
            } else {
                System.out.println(">>> USUARIO NO ENCONTRADO EN BD");
            }
        }

        filterChain.doFilter(request, response);
    }
}