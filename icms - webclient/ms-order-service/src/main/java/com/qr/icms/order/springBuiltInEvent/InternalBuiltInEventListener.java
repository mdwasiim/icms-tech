package com.qr.icms.order.springBuiltInEvent;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class InternalBuiltInEventListener {

    @Async
    @EventListener
    public void callEvent1(InternalBuiltInEventModel builtInEventModel) {
        System.out.println("calling from event 1 "+builtInEventModel.getMessage()+" Thread name " +Thread.currentThread().getName());
    }

    @Async
    @EventListener
    public void callEvent2(InternalBuiltInEventModel builtInEventModel) {
        System.out.println("calling from event 2 "+builtInEventModel.getMessage() +" Thread name " +Thread.currentThread().getName());
    }

    @Async
    @EventListener
    public void callEvent3(InternalBuiltInEventModel builtInEventModel) {
        System.out.println("calling from event 3 "+builtInEventModel.getMessage() +" Thread name " +Thread.currentThread().getName());
    }

    @Async
    @EventListener
    public void callEvent4(InternalBuiltInEventModel builtInEventModel) {
        System.out.println("calling from event 1 "+builtInEventModel.getMessage() +" Thread name " +Thread.currentThread().getName());
    }
}
