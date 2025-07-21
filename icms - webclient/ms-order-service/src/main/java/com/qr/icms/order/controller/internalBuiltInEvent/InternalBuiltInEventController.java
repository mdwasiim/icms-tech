package com.qr.icms.order.controller.internalBuiltInEvent;

import com.qr.icms.order.springBuiltInEvent.InternalBuiltInEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders/built-in-event")
public class InternalBuiltInEventController {

    @Autowired
    private InternalBuiltInEventPublisher internalBuiltInEventPublisher;
    @GetMapping("/{message}")
    public String processEvent(@PathVariable String message){
        internalBuiltInEventPublisher.createEvent(message);
        return "Internal Event triggered";
    }
}
