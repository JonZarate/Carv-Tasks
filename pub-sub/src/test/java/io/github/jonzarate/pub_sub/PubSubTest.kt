package io.github.jonzarate.pub_sub

import org.junit.Assert.assertEquals
import org.junit.Test

class PubSubTest {
    @Test
    fun classTakesAnyInput() {
        val expectedData = listOf("a String", 1234F, Example(), null)

        val subscriber = FakeSubscriber()

        val pubSub = PubSub().apply {
            addSubscriber(subscriber)
        }

        pubSub.publishEvent(Event(expectedData[0]))
        pubSub.publishEvent(Event(expectedData[1]))
        pubSub.publishEvent(Event(expectedData[2]))
        pubSub.publishEvent(Event(expectedData[3]))

        assertEquals(subscriber.data, expectedData)
    }
}