package org.cabradati.reinos.eventbus.utils

import com.google.common.eventbus.EventBus
import org.cabradati.reinos.eventbus.events.MensagemEvent

private val eventBus = EventBus()

fun <T> registrarSubscriber(subscriber: Subscriber<T>) {
    eventBus.register(subscriber)
}

fun enviarEvento(evento: Evento) {
    eventBus.post(evento)
}

fun enviarEventoLog(mensagem: String) {
    enviarEvento(MensagemEvent(mensagem))
}