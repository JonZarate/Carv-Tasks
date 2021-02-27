package io.github.jonzarate.pub_sub

class Example {

    fun example() {
        val pubSub = PubSub()
        pubSub.publishEvent(Event("a String"))
        pubSub.publishEvent(Event(1234F))
        pubSub.publishEvent(Event(Example()))
        pubSub.publishEvent(Event(null))
    }

}