package org.cabradati.reinos.commands.aliancas

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.cabradati.reinos.models.SolicitacaoAlianca
import org.cabradati.reinos.services.ReinosService
import org.cabradati.reinos.services.SolicitacaoAliancaService

class ConsultarSolicitacaoAliancaCommand : CommandExecutor {

    private val solicitacaoAliancaService = SolicitacaoAliancaService()
    private val reinosService = ReinosService()

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {
        if (sender !is Player) return false

        val reinoConsultante = reinosService
            .getByLider(sender.uniqueId.toString())
            .get()

        if (reinoConsultante.isEmpty) {
            sender.sendMessage("você não é lider de nenhum reino")
            return false
        }

        val solicitacoes = solicitacaoAliancaService
            .getSolicitacoesByReinoConvidado(reinoConsultante.documents[0].id)
            .get().documents.map {
                it.toObject(SolicitacaoAlianca::class.java)
            }

        when(solicitacoes.isEmpty()) {
            true -> sender.sendMessage("você não possui solicitações de aliança")
            false -> {
                sender.sendMessage("### Solicitações ###")
                solicitacoes.forEach {
                    sender.sendMessage("- ${it.nomeReinoSolicitante}")
                }
            }
        }

        return true
    }

}