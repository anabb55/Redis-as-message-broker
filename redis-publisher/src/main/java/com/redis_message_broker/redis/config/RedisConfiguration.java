package com.redis_message_broker.redis.config;

import com.redis_message_broker.redis.publisher.MessagePublisher;
import com.redis_message_broker.redis.publisher.Publisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

@Configuration
public class RedisConfiguration {


    //manage connection with redis
    @Bean
    LettuceConnectionFactory lettuceConnectionFactory(){
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setHostName("localhost");
        configuration.setPort(6379);
        return new LettuceConnectionFactory(configuration);
    }

    @Bean
    public ChannelTopic topic() {
        return new ChannelTopic("smsQueue");
    }



    @Bean
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory)
    {
        RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
        return redisTemplate;
    }
//    @Bean
//    public MessagePublisher messagePublisher()
//    {
//        return new Publisher(redisTemplate(lettuceConnectionFactory()),topic());
//    }
}
