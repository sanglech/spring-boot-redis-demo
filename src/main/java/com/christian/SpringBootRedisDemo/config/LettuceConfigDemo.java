package com.christian.SpringBootRedisDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import static io.lettuce.core.ReadFrom.REPLICA_PREFERRED;

@Configuration
public class LettuceConfigDemo {
    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        //Enables writes to master but reads from replicas
        LettuceClientConfiguration clientConfig = LettuceClientConfiguration.builder()
                .readFrom(REPLICA_PREFERRED)
                .build();
        return new LettuceConnectionFactory(new RedisStandaloneConfiguration("server", 6379));
    }
}
