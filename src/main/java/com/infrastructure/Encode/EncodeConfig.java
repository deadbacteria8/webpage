package com.infrastructure.Encode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class EncodeConfig {
    @Value("${encoder.saltLength}")
    private Integer saltLength;
    @Value("${encoder.hashLength}")
    private Integer hashLength;
    @Value("${encoder.parallelism}")
    private Integer parallelism;
    @Value("${encoder.memory}")
    private Integer memory;
    @Value("${encoder.iterations}")
    private Integer iterations;
    @Bean
    public PasswordEncoder encoder() {
        return new Argon2PasswordEncoder(
                this.saltLength, this.hashLength, this.parallelism, this.memory, this.iterations
        );
    }
}
