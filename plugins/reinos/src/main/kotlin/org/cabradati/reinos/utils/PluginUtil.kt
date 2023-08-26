package org.cabradati.reinos.utils

import org.bukkit.command.CommandExecutor

fun registrarComando(
    caminho: String,
    executor: CommandExecutor
) {
    getPluginContainerDI().getCommand(caminho)
        ?.setExecutor(executor)
}