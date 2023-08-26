package org.cabradati.reinos.utils

import org.bukkit.event.Listener

interface ListenerUtil<T> : Listener {
    fun handle(event: T)
}