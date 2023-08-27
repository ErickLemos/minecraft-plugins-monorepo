package org.cabradati.reinos.eventbus.events

import org.cabradati.reinos.eventbus.utils.Evento

class LogEvent(
    val mensagem: String
) : Evento