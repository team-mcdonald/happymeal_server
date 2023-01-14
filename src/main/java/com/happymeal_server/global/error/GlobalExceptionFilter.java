package com.happymeal_server.global.error;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class GlobalExceptionFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (CustomException e) {
            writerErrorCode(response, e.getStatus(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            writerErrorCode(response, HttpStatus.INTERNAL_SERVER_ERROR, "서버 에러");
        }
    }

    private void writerErrorCode(HttpServletResponse response, HttpStatus status, String message) throws IOException {
        ErrorResponse errorResponse = new ErrorResponse(
                status.value(),
                message
        );

        response.setStatus(status.value());
        response.setCharacterEncoding("UTF-8");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().write(errorResponse.toString());
    }
}
