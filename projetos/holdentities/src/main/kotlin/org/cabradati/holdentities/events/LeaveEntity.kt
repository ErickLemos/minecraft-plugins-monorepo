package org.cabradati.holdentities.events

import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.player.PlayerToggleSneakEvent
import org.cabradati.generalutils.ListenerUtil
import org.cabradati.holdentities.extensions.noPassengers

class LeaveEntity : ListenerUtil<PlayerToggleSneakEvent> {

    @EventHandler(priority = EventPriority.LOW)
    override fun handle(event: PlayerToggleSneakEvent) {

        if (event.player.noPassengers()) return

        event.player.removePassenger(event.player.passengers[0])

    }

}