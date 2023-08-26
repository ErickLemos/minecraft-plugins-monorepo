package org.cabradati.reinos.eventbus.subscribers

import com.google.common.eventbus.Subscribe
import org.cabradati.reinos.eventbus.events.PluginInitializationEvent
import org.cabradati.reinos.eventbus.utils.Subscriber

class PluginInitializationSubscriber : Subscriber<PluginInitializationEvent> {

    @Subscribe
    override fun subscribe(event: PluginInitializationEvent) {
        println("plugin inicializado com sucesso")
    }

}