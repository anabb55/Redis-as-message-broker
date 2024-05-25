package com.redis_message_broker.redis.publisher;

import org.springframework.stereotype.Component;

@Component
public interface MessagePublisher {

    public void publisher(String message);
}
