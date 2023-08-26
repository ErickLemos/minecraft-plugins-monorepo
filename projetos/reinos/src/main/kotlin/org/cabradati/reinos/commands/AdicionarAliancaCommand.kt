package org.cabradati.reinos.commands

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.cabradati.reinos.models.Alianca
import org.cabradati.reinos.models.Reino
import org.cabradati.reinos.services.ReinosService

class AdicionarAliancaCommand : CommandExecutor {

    private val reinosService = ReinosService()

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {
        if (sender !is Player) return false

        val nomeReinoConvidado = checkNotNull(args?.get(0))

        val reinoSolicitanteRef = reinosService
            .getByLider(sender.uniqueId.toString())
            .get()

        val reinoConvidadoRef = reinosService
            .getByName(nomeReinoConvidado)
            .get()

        if (reinoSolicitanteRef.isEmpty) {
            sender.sendMessage("você não é lider de nenhum reino")
            return false
        }

        if (reinoConvidadoRef.isEmpty) {
            sender.sendMessage("reino informado não existe")
        }

        val reinoSolicitante = reinoSolicitanteRef.documents[0]
            .toObject(Reino::class.java)

        return true
    }

}