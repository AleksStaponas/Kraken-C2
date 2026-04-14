package com.example.Kraken_C2.Config.APIControllers;

import com.example.Kraken_C2.Config.APIControllers.RateLimitingFilter;
import io.github.bucket4j.*;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class RateLimitConfig {

    @Bean
    public Bucket bucket() {
        Bandwidth limit = Bandwidth.classic(
                1115,//temp extra tokens
                Refill.intervally(5, Duration.ofMinutes(1))
        );
        return Bucket4j.builder()
                .addLimit(limit)
                .build();
    }

    @Bean
    public RateLimitingFilter rateLimitingFilter(Bucket bucket) {
        return new RateLimitingFilter(bucket);
    }

    @Bean
    public FilterRegistrationBean<RateLimitingFilter> filterRegistration(RateLimitingFilter filter) {
        FilterRegistrationBean<RateLimitingFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(filter);
        registration.addUrlPatterns("/api/*");
        registration.setOrder(1);
        return registration;
    }
}
