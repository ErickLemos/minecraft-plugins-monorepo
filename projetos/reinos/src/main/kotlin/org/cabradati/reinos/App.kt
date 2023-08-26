package org.cabradati.reinos

import com.google.auth.oauth2.GoogleCredentials
import com.google.common.eventbus.EventBus
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import org.bukkit.plugin.java.JavaPlugin
import org.cabradati.reinos.commands.aliancas.EnviarSolicitacaoAliancaCommand
import org.cabradati.reinos.commands.reinos.AdicionarReinoCommand
import org.cabradati.reinos.commands.reinos.RemoverReinoCommand
import org.cabradati.reinos.subscribers.ExampleSubscriber
import org.cabradati.reinos.utils.DIContainer
import javax.swing.event.ChangeEvent


class App : JavaPlugin() {

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

        val eventBus = EventBus()
        eventBus.register(ExampleSubscriber())

        val event = ChangeEvent("")
        eventBus.post(event)

        super.onEnable()

    }

}
