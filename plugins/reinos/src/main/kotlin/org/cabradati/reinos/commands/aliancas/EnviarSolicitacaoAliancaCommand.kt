package org.cabradati.reinos.commands.aliancas

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.cabradati.reinos.eventbus.events.MensagemChatEvent
import org.cabradati.reinos.eventbus.utils.enviarEvento
import org.cabradati.reinos.models.reino.Reino
import org.cabradati.reinos.models.solicitacaoalianca.SolicitacaoAlianca
import org.cabradati.reinos.services.ReinosService
import org.cabradati.reinos.services.SolicitacaoAliancaService
import org.cabradati.reinos.utils.info
import java.util.*

class EnviarSolicitacaoAliancaCommand : CommandExecutor {

    private val reinosService = ReinosService()
    private val solicitacaoAliancaService = SolicitacaoAliancaService()

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

        val solicitacaoAlianca = SolicitacaoAlianca(
            nomeReinoSolicitante = checkNotNull(reinoSolicitanteRef.documents[0].getString("nome")),
            uidReinoSolicitante = reinoSolicitanteRef.documents[0].id,
            uidReinoConvidado = reinoConvidadoRef.documents[0].id
        )

        solicitacaoAliancaService.enviarSolicitacao(solicitacaoAlianca)

        val uidPlayerMensagem = reinoConvidadoRef.documents[0]
            .toObject(Reino::class.java)
            .uidPlayerLider

        info("[ESAC-001] enviando mensagem para player lider do reino: $uidPlayerMensagem")
        enviarEvento(MensagemChatEvent(
            mensagem = "seu reino recebeu uma solicitação de aliança",
            uidDestinatario = UUID.fromString(uidPlayerMensagem)
        ))

        sender.sendMessage("solicitacao enviada com sucesso")

        return true
    }

}