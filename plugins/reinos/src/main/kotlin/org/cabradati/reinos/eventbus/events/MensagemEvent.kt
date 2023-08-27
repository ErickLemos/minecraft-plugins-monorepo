package org.cabradati.reinos.eventbus.events

import org.cabradati.reinos.eventbus.utils.Evento

class MensagemEvent(
    val mensagem: String
) : Evento {
}