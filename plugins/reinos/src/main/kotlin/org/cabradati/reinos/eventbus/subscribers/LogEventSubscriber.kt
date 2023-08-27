package org.cabradati.reinos.eventbus.subscribers

import com.google.common.eventbus.Subscribe
import org.cabradati.reinos.eventbus.events.LogEvent
import org.cabradati.reinos.eventbus.utils.Subscriber
import org.cabradati.reinos.utils.info

class LogEventSubscriber : Subscriber<LogEvent> {

    @Subscribe
    override fun subscribe(event: LogEvent) {
        info("evento - ${event.mensagem}")
    }

}