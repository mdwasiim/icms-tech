package com.qr.icms.order.springBuiltInEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class InternalBuiltInEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public InternalBuiltInEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void createEvent(String message){

        InternalBuiltInEventModel builtInEventModel = new InternalBuiltInEventModel(message);
        applicationEventPublisher.publishEvent(builtInEventModel);

    }

}
