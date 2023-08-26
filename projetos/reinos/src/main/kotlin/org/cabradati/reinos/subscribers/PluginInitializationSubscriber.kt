package org.cabradati.reinos.subscribers

import com.google.common.eventbus.Subscribe
import org.cabradati.reinos.subscribers.events.PluginInitializationEvent

class PluginInitializationSubscriber : Subscriber<PluginInitializationEvent> {

    @Subscribe
    override fun subscribe(event: PluginInitializationEvent) {
        println("plugin inicializado com sucesso")
    }

}