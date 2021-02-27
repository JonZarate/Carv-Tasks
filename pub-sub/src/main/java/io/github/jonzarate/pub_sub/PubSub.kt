package io.github.jonzarate.pub_sub

class PubSub {

    private val subscribers = mutableListOf<EventSubscriber>()

    @Synchronized
    fun addSubscriber(subscriber: EventSubscriber) {
        this.subscribers.add(subscriber)
    }

    @Synchronized
    fun removeSubscriber(subscriber: EventSubscriber) : Boolean {
        return this.subscribers.remove(subscriber)
    }

    @Synchronized
    fun <T: Any?> publishEvent(event: Event<T>) {
        subscribers.forEach { subscriber ->
            subscriber.onEvent(event)
        }
    }
}