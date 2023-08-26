package org.cabradati.reinos.commands.reinos

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.cabradati.reinos.models.Reino
import org.cabradati.reinos.services.ReinosService

class AdicionarReinoCommand : CommandExecutor {

    private val reinosService = ReinosService()

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {
        if (sender !is Player) return false

        val nomeDoReino = checkNotNull(args?.get(0))

        val reino = Reino(
            nome = nomeDoReino,
            uidPlayerLider = sender.uniqueId.toString()
        )

        reinosService.add(reino)
        sender.sendMessage("reino $nomeDoReino criado com sucesso!")

        return true
    }

}