package org.cabradati.reinos.eventbus.subscribers

import com.google.common.eventbus.Subscribe
import org.cabradati.reinos.eventbus.events.MensagemChatEvent
import org.cabradati.reinos.eventbus.utils.Subscriber
import org.cabradati.reinos.utils.di.getPluginContainerDI
import org.cabradati.reinos.utils.info

class MensagemChatEventSubscriber : Subscriber<MensagemChatEvent> {

    @Subscribe
    override fun subscribe(event: MensagemChatEvent) {
        getPluginContainerDI().server
            .getPlayer(event.uidDestinatario)
            ?.sendMessage(event.mensagem)
    }

}