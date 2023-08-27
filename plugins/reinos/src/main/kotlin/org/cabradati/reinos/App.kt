package org.cabradati.reinos

import org.bukkit.plugin.java.JavaPlugin
import org.cabradati.reinos.commands.aliancas.ConsultarSolicitacaoAliancaCommand
import org.cabradati.reinos.commands.aliancas.EnviarSolicitacaoAliancaCommand
import org.cabradati.reinos.commands.reinos.AdicionarReinoCommand
import org.cabradati.reinos.commands.reinos.RemoverReinoCommand
import org.cabradati.reinos.eventbus.events.PluginInitializationEvent
import org.cabradati.reinos.eventbus.subscribers.PluginInitializationSubscriber
import org.cabradati.reinos.eventbus.utils.enviarEvento
import org.cabradati.reinos.eventbus.utils.registrarSubscriber
import org.cabradati.reinos.utils.di.setPluginContainerDI
import org.cabradati.reinos.utils.inicializarFirebase
import org.cabradati.reinos.utils.registrarComando


class App : JavaPlugin() {

    init {
        inicializarFirebase()
        setPluginContainerDI(this)
    }

    override fun onEnable() {

        registrarComando("adicionar-reino", AdicionarReinoCommand())
        registrarComando("adicionar-reino", AdicionarReinoCommand())
        registrarComando("remover-reino", RemoverReinoCommand())
        registrarComando("enviar-convite-de-alianca", EnviarSolicitacaoAliancaCommand())
        registrarComando("consultar-convites-de-alianca", ConsultarSolicitacaoAliancaCommand())

        registrarSubscriber(PluginInitializationSubscriber())
        enviarEvento(PluginInitializationEvent())

        super.onEnable()

    }

}
