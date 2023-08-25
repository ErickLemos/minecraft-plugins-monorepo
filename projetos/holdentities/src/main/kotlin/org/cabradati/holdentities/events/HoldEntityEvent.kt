package org.cabradati.holdentities.events

import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.player.PlayerInteractEntityEvent
import org.cabradati.dicontainer.DIContainer
import org.cabradati.generalutils.ListenerUtil
import org.cabradati.holdentities.App
import org.cabradati.holdentities.extensions.canHold

class HoldEntityEvent(
    private val diContainer: DIContainer
) : ListenerUtil<PlayerInteractEntityEvent> {

    @EventHandler(priority = EventPriority.LOW)
    override fun handle(event: PlayerInteractEntityEvent) {

        val toggleDaEntidade = diContainer.config.getBoolean(App.PREFIXO_ENTIDADE_SEGURAVEL + event.rightClicked.type)
        if (!(event.player.canHold() && toggleDaEntidade)) return

        val player = event.player
        val entity = event.rightClicked

        player.addPassenger(entity)

    }

}