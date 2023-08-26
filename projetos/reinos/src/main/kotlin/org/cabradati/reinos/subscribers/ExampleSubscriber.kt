package org.cabradati.reinos.subscribers

import com.google.common.eventbus.Subscribe
import javax.swing.event.ChangeEvent


class ExampleSubscriber {
    @Subscribe
    fun recordCustomerChange(e: ChangeEvent) {
        println(e)
    }
}