package org.cabradati.reinos.eventbus.subscribers

import com.google.common.eventbus.Subscribe
import org.cabradati.reinos.eventbus.events.MensagemEvent
import org.cabradati.reinos.eventbus.utils.Subscriber
import org.cabradati.reinos.utils.info

class MensagemEventSubscriber : Subscriber<MensagemEvent> {

    @Subscribe
    override fun subscribe(event: MensagemEvent) {
        info("evento - ${event.mensagem}")
    }

}