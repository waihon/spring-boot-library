// https://www.udemy.com/course/full-stack-react-and-java-spring-boot-the-developer-guide/learn/lecture/33402220#questions/20780734
// https://www.udemy.com/course/full-stack-react-and-java-spring-boot-the-developer-guide/learn/lecture/34733660#questions/19389664

package com.waihon.luv2code.springbootlibrary.config;

import com.okta.spring.boot.oauth.Okta;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        // Disable Cross Site Request Forgery
        http.csrf(AbstractHttpConfigurer::disable);

        // Protect endpoints at /api/<type>/secure
        http.authorizeHttpRequests(
                // Endpoints matched the patterns require authentication while
                // any other request is permitted.
                configurer ->
                         configurer
                                 .requestMatchers("/api/books/secure/**",
                                         "/api/reviews/secure/**",
                                         "/api/messages/secure/**").authenticated()
                                 .anyRequest().permitAll())
                .oauth2ResourceServer(server ->
                        server.jwt(Customizer.withDefaults()));

        // Add CORS filters with default configurations
        http.cors(Customizer.withDefaults());

        // Add content negotiation strategy
        http.setSharedObject(ContentNegotiationStrategy.class,
                new HeaderContentNegotiationStrategy());

        // Force a non-empty response body for 401's to make the response friendly
        Okta.configureResourceServer401ResponseBody(http);

        return http.build(); // using build design patter
    }
}
