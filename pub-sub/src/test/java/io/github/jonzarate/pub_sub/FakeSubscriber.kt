package io.github.jonzarate.pub_sub

class FakeSubscriber : EventSubscriber {

    val data = mutableListOf<Any?>()

    override fun onEvent(event: Event<*>?) {
        data.add(event?.value)
    }
}