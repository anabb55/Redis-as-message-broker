package com.redis_message_broker.redis.controller;



import com.redis_message_broker.redis.publisher.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class PublishController {

    private static Logger log = LoggerFactory.getLogger(PublishController.class);

    @Autowired
    Publisher publisher;

    @RequestMapping(value = "/publisher",method = RequestMethod.POST)
    public void publish(@RequestBody String message){
        log.info(">> Publishing : "+message);
        publisher.publisher(message);
    }
}
