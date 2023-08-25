package org.cabradati.generalutils

import org.bukkit.event.Listener

interface ListenerUtil<T> : Listener {
    fun handle(event: T)
}