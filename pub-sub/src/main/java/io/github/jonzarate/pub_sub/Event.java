package io.github.jonzarate.pub_sub;

public class Event<T> {

    T value;

    Event(T value) {
        this.value = value;
    }

}
