package com.randylayne.eventhandler;

public interface EventBusService {
  boolean send(Event event);

  void asyncSend(Event event);
}
