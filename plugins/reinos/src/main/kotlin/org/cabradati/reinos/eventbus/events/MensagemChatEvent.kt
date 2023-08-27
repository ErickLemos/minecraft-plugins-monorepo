package org.cabradati.reinos.eventbus.events

import org.cabradati.reinos.eventbus.utils.Evento
import java.util.UUID

class MensagemChatEvent(
    val mensagem: String,
    val uidDestinatario: UUID
) : Evento