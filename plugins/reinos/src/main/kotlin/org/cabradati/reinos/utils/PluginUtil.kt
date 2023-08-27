package org.cabradati.reinos.utils

import org.bukkit.command.CommandExecutor
import org.cabradati.reinos.utils.di.getPluginContainerDI

fun registrarComando(
    caminho: String,
    executor: CommandExecutor
) {
    getPluginContainerDI().getCommand(caminho)
        ?.setExecutor(executor)
}

fun info(mensagem: String) {
    getPluginContainerDI().logger.info(mensagem)
}