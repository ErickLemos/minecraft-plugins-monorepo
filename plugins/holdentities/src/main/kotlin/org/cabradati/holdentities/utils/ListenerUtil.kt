package org.cabradati.holdentities.utils

import org.bukkit.event.Listener

interface ListenerUtil<T> : Listener {
    fun handle(event: T)
}