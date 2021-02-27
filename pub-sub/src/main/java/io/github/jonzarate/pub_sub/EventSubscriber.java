package io.github.jonzarate.pub_sub;

public interface EventSubscriber {
    void onEvent(Event<?> event);
}
