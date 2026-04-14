package com.example.Kraken_C2.Config.APIControllers;

import io.github.bucket4j.Bucket;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;

public class RateLimitingFilter implements Filter {

    private final Bucket bucket;

    public RateLimitingFilter(Bucket bucket) {
        this.bucket = bucket;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        Date date = new Date();


        if (bucket.tryConsume(1)) {
            chain.doFilter(request, response);
        } else {
            System.out.println("Request blocked: code 429 Too many requests invoked time:"+date);
            HttpServletResponse res = (HttpServletResponse) response;
            res.setStatus(429);
            res.getWriter().write("Too many requests");
        }
    }
}
