package org.cabradati.reinos

import com.google.auth.oauth2.GoogleCredentials
import com.google.common.eventbus.EventBus
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import org.bukkit.plugin.java.JavaPlugin
import org.cabradati.reinos.commands.aliancas.EnviarSolicitacaoAliancaCommand
import org.cabradati.reinos.commands.reinos.AdicionarReinoCommand
import org.cabradati.reinos.commands.reinos.RemoverReinoCommand
import org.cabradati.reinos.subscribers.PluginInitializationSubscriber
import org.cabradati.reinos.subscribers.events.PluginInitializationEvent
import org.cabradati.reinos.utils.DIContainer


class App : JavaPlugin() {

    private val eventBus = EventBus()

    override fun onEnable() {

        FirebaseApp.initializeApp(
            FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.getApplicationDefault())
                .build()
        )

        val diContainer = DIContainer(
            this,
            server,
            config,
            logger
        )

        getCommand("adicionar-reino")?.setExecutor(AdicionarReinoCommand(diContainer))
        getCommand("remover-reino")?.setExecutor(RemoverReinoCommand(diContainer))
        getCommand("adicionar-alianca")?.setExecutor(EnviarSolicitacaoAliancaCommand(diContainer))


        eventBus.register(PluginInitializationSubscriber())
        eventBus.post(PluginInitializationEvent())

        super.onEnable()

    }

}
