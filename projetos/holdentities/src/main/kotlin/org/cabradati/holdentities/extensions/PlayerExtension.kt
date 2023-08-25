package org.cabradati.holdentities.extensions

import org.bukkit.entity.Player

fun Player.canHold(): Boolean {
    return this.passengers.isEmpty() &&
            this.equipment.itemInMainHand.amount == 0
}